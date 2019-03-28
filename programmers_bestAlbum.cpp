#include <string>
#include <vector>
#include <iostream>
#include <map>
#include <utility>

using namespace std;

vector<int> solution(vector<string> genres, vector<int> plays) {
	vector<string>::iterator iter1;
	vector<int>::iterator iter2;
	for (iter1 = genres.begin(); iter1 != genres.end(); ++iter1) {
		cout << *iter1 << " ";
	}
	cout << endl;
	for (iter2 = plays.begin(); iter2 != plays.end(); ++iter2) {
		cout << *iter2 << " ";
	}
	cout << endl;
	map<string, int> genre_value;
	vector<string> list;

	for (auto &genre : genres) {
		if (genre_value.find(genre) != genre_value.end()) {
			genre_value
		}
	}

	//for (int i = 0; i<genres.size(); i++) {
	//	if (genre[genres[i]] == 0) {
	//		genre[genres[i]] += plays[i];
	//		list.push_back(genres[i]);
	//	}
	//	else {
	//		genre[genres[i]] += plays[i];
	//	}
	//}

	//map<string, int>::iterator iter4;
	///*for (iter4 = genre.begin(); iter4 != genre.end(); ++iter4)
	//	cout << "(" << (*iter4).first << "," << (*iter4).second << ")" << " ";
	//cout << endl;

	//for (iter1 = list.begin(); iter1 != list.end(); ++iter1) {
	//	cout << *iter1 << " ";
	//}cout << endl;*/
	//



	vector<int> answer;
	return answer;
}

int main() {
	vector<string> genres;
	vector<int> plays;
	genres.push_back("classic");
	genres.push_back("pop");
	genres.push_back("classic");
	genres.push_back("classic");
	genres.push_back("pop");
	plays.push_back(500);
	plays.push_back(600);
	plays.push_back(150);
	plays.push_back(800);
	plays.push_back(2500);
	solution(genres, plays);
	system("pause");
	return 0;
}
