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
#include <boost/beast/html/html_parser.hpp>
#include <boost/algorithm/string.hpp>

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
                // Parse the HTML response using a library like Boost.Beast or libxml2
                // Extract the desired information and store it in the respective vectors
                // titles.push_back(...);
                // years.push_back(...);
                // ratings.push_back(...);
                // genres.push_back(...);
                // runtimes.push_back(...);
                // imdb_ratings.push_back(...);
                // metascores.push_back(...);
                // votes.push_back(...);
            

                if (res != CURLE_OK) {
                    cerr << "curl_easy_perform() failed: " << curl_easy_strerror(res) << endl;
                } else {
                    // Parse the HTML response using Boost.Beast
                    boost::beast::html_document<boost::beast::string_view> doc;
                    doc.parse(readBuffer);

                    // Extract the desired information and store it in the respective vectors
                    // For example, to extract the titles:
                    for (const auto& title : doc.find_all(boost::beast::html_match_selector("h3.lister-item-header a"))) {
                        titles.push_back(boost::beast::html_text(title));
                    }

                    // Similarly, you can extract other information like years, ratings, genres, etc.

                    // ...
                }
            }

            readBuffer.clear();

            // Introduce a random delay between requests
            srand(time(NULL));
            int delay = rand() % 8 + 8; // Random delay between 8 and 15 seconds
            this_thread::sleep_for(chrono::seconds(delay));
        }

        curl_easy_cleanup(curl);
    }

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

      myCSV.open ("imdb_top_50_scifi.csv");
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