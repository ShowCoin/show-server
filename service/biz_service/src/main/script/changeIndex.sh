#!/bin/sh
APP_PATH=/data/apps/service/biz_service-1.0
USER_INDEX_DIR=/data/search/user_index
USER_INDEX_TMP_DIR=/data/search/user_index_tmp

service biz stop
cd $APP_PATH/
echo "Starting recreate index..."
stat=`sh index.sh start`
if [ $stat -ne 0 ]; then
echo "reindex failed!"
exit 1
fi
sleep 10

echo "Create index complete!"


echo "Starting Copy newindex to userindex..."
rm -rf $USER_INDEX_DIR/*
mv $USER_INDEX_TMP_DIR/* $USER_INDEX_DIR/
if [ $? -ne 0 ]; then
echo "Copy newindex to userindex error!"
fi

service biz start
echo "Change index complete!"
