#include <string>
#include <vector>
#include <iostream>
#include <map>
#include <utility>
#include <queue>
#include <string>

using namespace std;

//test for genre, plays with vector<t>
template <typename T>
void vector_iter(vector<T> testee) {
	vector<T>::iterator iter;
	for (iter = testee.begin(); iter != testee.end(); ++iter) {
		cout << *iter << " ";
	}
	cout << endl;
}

//test for genre_value with map<T1,T2>
template <typename T1, typename T2>
void map_iter(map<T1,T2> a) {
	map<T1, T2>::iterator iter;
	for (iter = a.begin(); iter != a.end(); ++iter)
		cout << "(" << (*iter).first << "," << (*iter).second << ")" << " ";
	cout << endl;
}

struct song {
	int idx;
	int play_number;
};

struct cmp {
	bool operator()(song a, song b) {
		if (a.play_number < b.play_number) {
			return a.play_number < b.play_number;
		}
		else if (a.play_number == b.play_number) {
			if (a.idx < b.idx) {
				return false;
			}
			else {
				return true;
			}
		}
		else {
			return false;
		}
	}
};

vector<int> solution(vector<string> genres, vector<int> plays) {
	/*vector_iter(genres);
	vector_iter(plays);*/
	map<string, int> genre_value;
	vector<string> list;

	for (int i = 0; i < genres.size(); i++) {
		if (genre_value.find(genres[i]) != genre_value.end()) {
			genre_value[genres[i]] += plays[i];
		}
		else {
			genre_value.insert(make_pair(genres[i], plays[i]));
		}
	}
	map<string, int>::iterator iter4;
	/*map_iter(genre_value);*/
	
	priority_queue<int, vector<int>,less<int>> pq;

	for (iter4 = genre_value.begin(); iter4 != genre_value.end(); ++iter4){
		pq.push((*iter4).second);
	}

	map<int, string> value_genre;
	for (iter4 = genre_value.begin(); iter4 != genre_value.end(); ++iter4) {
		value_genre.insert(make_pair((*iter4).second, (*iter4).first));
	}
	/*map_iter(value_genre);*/

	vector<string> ranked_genre;
	int length = pq.size();
	for (int i = 0; i < length; i++) {
		int good = pq.top();
		ranked_genre.push_back(value_genre[good]);
		pq.pop();
	}

	struct song idx_value;
	map<string, priority_queue<song, vector<song>, cmp>> genre_valueList;
	

	priority_queue<song, vector<song>, cmp> pq3;
	for (int i = 0; i < genres.size(); i++) {
		if (genre_valueList.find(genres[i]) != genre_valueList.end()) {
			idx_value.idx = i;
			idx_value.play_number = plays[i];
			genre_valueList[genres[i]].push(idx_value);
		}
		else {
			idx_value.idx = i;
			idx_value.play_number = plays[i];
			pq3.push(idx_value);
			genre_valueList[genres[i]]=pq3;
		}
	}

	vector<int> answer;
	for (int i = 0; i < ranked_genre.size(); i++) {
		if (genre_valueList[ranked_genre[i]].size() < 2) {
			answer.push_back(genre_valueList[ranked_genre[i]].top().idx);
			genre_valueList[ranked_genre[i]].pop();
		}
		else {
			for (int j = 0; j < 2; j++) {
				answer.push_back(genre_valueList[ranked_genre[i]].top().idx);
				genre_valueList[ranked_genre[i]].pop();
			}
		}
	}

	/*test_case*/
	int count = 0;
	vector<int>::iterator iter10;
	for (iter10 = answer.begin(); iter10 != answer.end(); ++iter10) {
		count++;
		if (count == answer.size()) {
			cout << (*iter10) << endl;
		}
		else {
			cout << (*iter10) << ", ";
		}
	}
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
