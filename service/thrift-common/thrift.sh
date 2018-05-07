#!/bin/bash

for file in `ls *.thrift`
do
	if [ $file != 'fb303.thrift' ]
	then
		echo "gen thirft for file $file"
		thrift --gen java -out ../proxy/src/main/java/ $file
	fi
done
