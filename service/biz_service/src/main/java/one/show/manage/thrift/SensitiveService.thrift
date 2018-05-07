namespace java one.show.manage.thrift.iface

include "WordView.thrift"
include "WordListView.thrift"
include "AppView.thrift"

service SensitiveServiceProxy{

  	string filter(1:string word,2:i32 appId);
  	
  	WordListView.WordListView findListByAppId(1:i32 appId, 2:string word, 3:i32 start, 4:i32 count);
  	
  	void save(1:WordView.WordView wordView);
  	
  	void deleteWord(1:i32 id);
  	
  	void update(1:i32 id, 2:string word);
  	
  	list<AppView.AppView> findAppList();
}

