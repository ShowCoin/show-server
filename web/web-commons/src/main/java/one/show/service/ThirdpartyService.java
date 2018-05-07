package one.show.service;

import one.show.user.thrift.view.UserView;

import java.util.List;

/**
 * Created by Haliaeetus leucocephalus on 18/1/6.
 */
public interface ThirdpartyService {
    public UserView getUserInfo(String id,  String token);
    
    public <T> List<T> getFoucsList(String id, String token) throws Exception;
}
