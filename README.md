服务端使用java语言开发，代码中涉及到主流框架：spring、mybatis、thrift、zookeeper、activemq、web3j 
采用服务化架构，使用thrift发布服务，
zookeeper用来做服务的注册和发现、配置管理，
activemq用来做消息处理 
数据库使用mysql分库分表、读写分离机制, 
以太坊智能合约交互采用开源框架web3j。 
代码目录结构 web：
提供api接口、后台管理系统、H5页面，使用spring mvc开发， 
service：根据功能划分不同的服务, 使用thrift发布服务，对外提供RPC调用，使用service目录下的 thrift.sh 生成thrift底层代码
