namespace java one.show.manage.thrift.view

include "WordView.thrift"
struct WordListView{
	1:list<WordView.WordView> wordList
	2:i32 count
}


