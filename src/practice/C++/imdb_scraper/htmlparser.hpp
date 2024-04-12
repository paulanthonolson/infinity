// htmlparser.cpp
#include <cctype>
#include <sstream>
#include <algorithm>

struct PageData {
    std::vector<std::string> titles;
    std::vector<std::string> years;
    std::vector<std::string> ratings;
    std::vector<std::string> genres;
    std::vector<std::string> runtimes;
    std::vector<double> imdbRatings;
    std::vector<int> metascores;
    std::vector<int> votes;
};

class HtmlParser {
private:
    std::string html_;
    size_t pos_;

    void skipWhitespace() {
        while (pos_ < html_.size() && std::isspace(html_[pos_]))
            ++pos_;
    }

    bool match(const std::string& str) {
        if (html_.compare(pos_, str.size(), str) == 0) {
            pos_ += str.size();
            return true;
        }
        return false;
    }

    std::string parseTagName() {
        skipWhitespace();
        size_t start = pos_;
        while (pos_ < html_.size() && !std::isspace(html_[pos_]) && html_[pos_] != '>')
            ++pos_;
        return html_.substr(start, pos_ - start);
    }

    std::string parseText() {
        skipWhitespace();
        size_t start = pos_;
        while (pos_ < html_.size() && html_[pos_] != '<')
            ++pos_;
        return html_.substr(start, pos_ - start);
    }

    std::string extractText(const std::string& tagName) {
        size_t start = html_.find("<" + tagName + ">");
        if (start != std::string::npos) {
            start += tagName.size() + 2;
            size_t end = html_.find("</" + tagName + ">", start);
            if (end != std::string::npos)
                return html_.substr(start, end - start);
        }
        return "";
    }

    std::vector<std::string> extractAllText(const std::string& tagName) {
        std::vector<std::string> result;
        size_t start = 0;
        while ((start = html_.find("<" + tagName + ">", start)) != std::string::npos) {
            start += tagName.size() + 2;
            size_t end = html_.find("</" + tagName + ">", start);
            if (end != std::string::npos) {
                result.push_back(html_.substr(start, end - start));
                start = end + tagName.size() + 3;
            }
        }
        return result;
    }

    double extractDouble(const std::string& tagName) {
        std::string text = extractText(tagName);
        std::stringstream ss(text);
        double value;
        ss >> value;
        return value;
    }

    int extractInt(const std::string& tagName) {
        std::string text = extractText(tagName);
        std::stringstream ss(text);
        int value;
        ss >> value;
        return value;
    }

public:
    void parse(const std::string& html) {
        html_ = html;
        pos_ = 0;
    }

    PageData extractPageData() {
        PageData data;
        data.titles = extractAllText("h3 class=\"lister-item-header\"");
        data.years = extractAllText("span class=\"lister-item-year text-muted unbold\"");
        data.ratings = extractAllText("div class=\"inline-block ratings-imdb-rating\"");
        data.genres = extractAllText("span class=\"genre\"");
        data.runtimes = extractAllText("span class=\"runtime\"");

        std::vector<std::string> imdbRatingStrings = extractAllText("div class=\"inline-block ratings-imdb-rating\"");
        for (const std::string& rating : imdbRatingStrings) {
            std::stringstream ss(rating);
            double value;
            ss >> value;
            data.imdbRatings.push_back(value);
        }

        std::vector<std::string> metascoreStrings = extractAllText("div class=\"inline-block ratings-metascore\"");
        for (const std::string& metascore : metascoreStrings) {
            std::stringstream ss(metascore);
            int value;
            ss >> value;
            data.metascores.push_back(value);
        }

        std::vector<std::string> voteStrings = extractAllText("p class=\"sort-num_votes-visible\"");
        for (const std::string& vote : voteStrings) {
            std::string cleanedVote = vote;
            cleanedVote.erase(std::remove(cleanedVote.begin(), cleanedVote.end(), ','), cleanedVote.end());
            std::stringstream ss(cleanedVote);
            int value;
            ss >> value;
            data.votes.push_back(value);
        }

        return data;
    }
};