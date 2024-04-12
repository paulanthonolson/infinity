#include <iostream>
#include <vector>
#include <string>
#include <cstdlib>
#include <ctime>
#include <chrono>
#include <thread>
#include <fstream>
#include <curl/curl.h>
#include <boost/beast.hpp>
#include <boost/beast/core.hpp>
#include <boost/beast/http.hpp>
#include <boost/beast/version.hpp>
#include <boost/asio/connect.hpp>
#include <boost/asio/ip/tcp.hpp>
#include <boost/asio/ssl/stream.hpp>
#include <boost/algorithm/string.hpp>
#include "html_parser.hpp" // Include the html.hpp header file

using namespace std;

size_t WriteCallback(void *contents, size_t size, size_t nmemb, void *userp) {
    ((string*)userp)->append((char*)contents, size * nmemb);
    return size * nmemb;
}

int main() {
    vector<int> pages;
    for (int i = 1; i <= 9951; i += 50) {
        pages.push_back(i);
    }

    vector<string> titles;
    vector<string> years;
    vector<string> ratings;
    vector<string> genres;
    vector<string> runtimes;
    vector<double> imdb_ratings;
    vector<int> metascores;
    vector<int> votes;

    CURL *curl;
    CURLcode res;
    string readBuffer;

    string url = "https://www.imdb.com/search/title?genres=sci-fi&start=";
    string html = fetchHtml(url);

    HtmlParser parser;
    parser.parse(html);
    
    // Process the scraped data
    // Convert years to integers
    
    for (string& year : years) {
        year = year.substr(year.length() - 5, 4);
    }

    // Standardize IMDB ratings
    vector<int> n_imdb;
    for (double rating : imdb_ratings) {
        n_imdb.push_back(static_cast<int>(rating * 10));
    }

    // Convert runtime to minutes
    vector<int> runtime_min;
    for (string& runtime : runtimes) {
        boost::replace_all(runtime, " min", "");
        runtime_min.push_back(stoi(runtime));
    }

    // Clean up genres
    for (string& genre : genres) {
        boost::trim(genre);
        boost::replace_all(genre, "\\n", "");
    }

    // Split genres into arrays
    vector<vector<string>> genre_arrays;
    for (string& genre : genres) {
        vector<string> genre_array;
        boost::split(genre_array, genre, boost::is_any_of(","));
        genre_arrays.push_back(genre_array);
    }

    // Write the final data to a CSV file
    // You can use a library like rapidcsv or implement your own CSV writing logic
    ofstream myCSV;
    myCSV.open("imdb_top_50_scifi.csv");
    myCSV << "Titles\n";
    myCSV << "Years\n";
    myCSV << "Ratings\n";
    myCSV << "Genres\n";
    myCSV << "Runtimes\n";
    myCSV << "IMDB Ratings\n";
    myCSV << "Metascores\n";
    myCSV << "Votes\n";
    myCSV.close();

    return 0;
}
