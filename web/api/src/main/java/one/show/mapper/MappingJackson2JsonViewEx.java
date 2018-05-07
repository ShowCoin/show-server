package one.show.mapper;


import java.util.Map;

import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

public class MappingJackson2JsonViewEx extends MappingJackson2JsonView {

    @Override
    protected Object filterModel(Map<String, Object> model) {
        Object result = super.filterModel(model);
        if (!(result instanceof Map)) {
            return result;
        }

        Map map = (Map) result;
        if (map.size() == 1) {
            return map.values().toArray()[0];
        }
        for(Object key : map.keySet()){
        	if (map.get(key) == null){
        		map.put(key, "");
        	}
        }
        return map;
    }
    


}