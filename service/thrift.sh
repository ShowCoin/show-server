#!/bin/bash

thriftlist="
id
stat
video
user
manage
search
pay
"

if [ ! -d "proxy/src/main/java/" ]; then
  mkdir -p proxy/src/main/java/
fi

for service in ${thriftlist} 
do
	if [ $service = "relation" -o $service = "stream" ];
	then
		echo "--------------- $service"
		path="${service}_service/src/main/java/one/show/$service/thrift"
	else
		path="biz_service/src/main/java/one/show/$service/thrift"
	fi
	
	echo "--------------- $path"
	cd $path
	./thrift.sh
	cd -
done



thriftlist2="
thrift-common
"
for path in ${thriftlist2}
do
	echo "--------------- $path"
	cd $path
	./thrift.sh
	cd -
done


