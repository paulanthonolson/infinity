#include <iostream>
#include <string>
#include <boost/asio.hpp>

using boost::asio::ip::tcp;
using namespace std;

class HtmlParser {
private:
    string html_;
    size_t pos_;

    void skipWhitespace() {
        while (pos_ < html_.size() && isspace(html_[pos_]))
            ++pos_;
    }

    bool match(const string& str) {
        if (html_.compare(pos_, str.size(), str) == 0) {
            pos_ += str.size();
            return true;
        }
        return false;
    }

    string parseTagName() {
        size_t start = pos_;
        while (pos_ < html_.size() && !isspace(html_[pos_]) && html_[pos_] != '>')
            ++pos_;
        return html_.substr(start, pos_ - start);
    }

    string parseText() {
        size_t start = pos_;
        while (pos_ < html_.size() && html_[pos_] != '<')
            ++pos_;
        return html_.substr(start, pos_ - start);
    }

public:
    void parse(const string& html) {
        html_ = html;
        pos_ = 0;

        while (pos_ < html_.size()) {
            skipWhitespace();

            if (match("<")) {
                if (match("/")) {
                    string tagName = parseTagName();
                    cout << "Closing tag: </" << tagName << ">" << endl;
                    match(">");
                } else {
                    string tagName = parseTagName();
                    cout << "Opening tag: <" << tagName << ">" << endl;
                    match(">");
                }
            } else {
                string text = parseText();
                cout << "Text: " << text << endl;
            }
        }
    }
};

string fetchHtml(const string& url) {
    boost::asio::io_context io_context;
    tcp::resolver resolver(io_context);
    tcp::socket socket(io_context);

    // Extract the domain name from the URL
    size_t pos = url.find("://");
    pos = (pos == string::npos) ? 0 : pos + 3;
    size_t end = url.find('/', pos);
    string domain = url.substr(pos, end - pos);

    // Resolve the domain name
    auto endpoints = resolver.resolve(domain, "http");

    // Connect to the server
    boost::asio::connect(socket, endpoints);

    // Send an HTTP GET request
    string request = "GET " + url + " HTTP/1.1\r\n";
    request += "Host: " + domain + "\r\n";
    request += "Connection: close\r\n\r\n";
    boost::asio::write(socket, boost::asio::buffer(request));

    // Read the response
    boost::asio::streambuf response;
    boost::asio::read_until(socket, response, "\r\n\r\n");

    // Extract the HTML content from the response
    istream response_stream(&response);
    string header;
    while (getline(response_stream, header) && header != "\r")
        ;
    string html;
    getline(response_stream, html, '\0');

    return html;
}