// imdb_scraper.cpp
#include <iostream>
#include <vector>
#include <string>
#include <cstdlib>
#include <ctime>
#include <chrono>
#include <thread>
#include <fstream>
#include <curl/curl.h>
#include <boost/algorithm/string.hpp>
#include "htmlparser.hpp"

using namespace std;

size_t WriteCallback(void* contents, size_t size, size_t nmemb, void* userp) {
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

    CURL* curl;
    CURLcode res;
    string readBuffer;

    curl = curl_easy_init();
    if (curl) {
        for (int page : pages) {
            string url = "https://www.imdb.com/search/title?genres=sci-fi&start=" + to_string(page) + "&explore=title_type,genres&ref_=adv_prv";
            curl_easy_setopt(curl, CURLOPT_URL, url.c_str());
            curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, WriteCallback);
            curl_easy_setopt(curl, CURLOPT_WRITEDATA, &readBuffer);
            res = curl_easy_perform(curl);
            if (res != CURLE_OK) {
                cerr << "curl_easy_perform() failed: " << curl_easy_strerror(res) << endl;
            } else {
                HtmlParser parser;
                parser.parse(readBuffer);
                PageData pageData = parser.extractPageData();

                titles.insert(titles.end(), pageData.titles.begin(), pageData.titles.end());
                years.insert(years.end(), pageData.years.begin(), pageData.years.end());
                ratings.insert(ratings.end(), pageData.ratings.begin(), pageData.ratings.end());
                genres.insert(genres.end(), pageData.genres.begin(), pageData.genres.end());
                runtimes.insert(runtimes.end(), pageData.runtimes.begin(), pageData.runtimes.end());
                imdb_ratings.insert(imdb_ratings.end(), pageData.imdbRatings.begin(), pageData.imdbRatings.end());
                metascores.insert(metascores.end(), pageData.metascores.begin(), pageData.metascores.end());
                votes.insert(votes.end(), pageData.votes.begin(), pageData.votes.end());

                readBuffer.clear();
            }
            srand(time(NULL));
            int delay = rand() % 8 + 8;
            this_thread::sleep_for(chrono::seconds(delay));
        }
        curl_easy_cleanup(curl);
    }

    // Process the scraped data
    for (string& year : years) {
        year = year.substr(1, 4);
    }

    vector<int> n_imdb;
    for (double rating : imdb_ratings) {
        n_imdb.push_back(static_cast<int>(rating * 10));
    }

    vector<int> runtime_min;
    for (string& runtime : runtimes) {
        boost::trim(runtime);
        runtime_min.push_back(stoi(runtime));
    }

    for (string& genre : genres) {
        boost::trim(genre);
        boost::replace_all(genre, "\n", "");
    }

    vector<vector<string>> genre_arrays;
    for (string& genre : genres) {
        vector<string> genre_array;
        boost::split(genre_array, genre, boost::is_any_of(","));
        genre_arrays.push_back(genre_array);
    }

    // Write the final data to a CSV file
    ofstream myCSV;
    myCSV.open("imdb_top_50_scifi.csv");
    myCSV << "Title,Year,Rating,Genre,Runtime,IMDb Rating,Metascore,Votes\n";
    for (size_t i = 0; i < titles.size(); ++i) {
        myCSV << "\"" << titles[i] << "\",";
        myCSV << years[i] << ",";
        myCSV << ratings[i] << ",";
        myCSV << "\"" << genres[i] << "\",";
        myCSV << runtime_min[i] << ",";
        myCSV << n_imdb[i] << ",";
        myCSV << metascores[i] << ",";
        myCSV << votes[i] << "\n";
    }
    myCSV.close();

    cout << "Data has been successfully scraped and saved to imdb_top_50_scifi.csv" << endl;

    return 0;
}