package com.lhx.cephfs.service.cluster.controller;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.lhx.cephfs.commons.domain.Node;
import com.lhx.cephfs.commons.mapper.NodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/cluster")
@CrossOrigin(value = "*", maxAge = 3600)
public class ClusterController {

    @Autowired
    NodeMapper nodeMapper;

    public static String jsonString(final String[] s,Object obj,final boolean mode){
        PropertyFilter profilter = new PropertyFilter(){
            @Override
            public boolean apply(Object object, String name, Object value) {
                for(int i=0;i<s.length;i++){
                    if(!name.equals(s[i])){
                        return mode;
                    }
                }
                return !mode;
            }
        };
        return JSON.toJSONString(obj, profilter);
    }


    public Map<String, Object> BodyBuilder(HashMap<String, Object> body,  HashMap<String, Object> args, String command, String nodeName){
        body.put("function", command);
        args.put("ceph-node", nodeName);
        body.put("args", args);
        return body;
    }

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public Map<String, Object> QueryClusterStatus(){

        Example example = new Example(Node.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isAdmin", 1);
        Node adminNode = nodeMapper.selectOneByExample(example);

        HashMap<String, Object> body = new HashMap<>();
        HashMap<String, Object> args = new HashMap<>();
        String url = "http://" + adminNode.getNodeIp() + "/command/" ;
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> query_cluster_status = BodyBuilder(body, args, "query_cluster_status", adminNode.getNodeName());
        Map map = restTemplate.postForObject(url, query_cluster_status, Map.class);

//        Map<String, Object> query_monmap_status = BodyBuilder(body, args, "query_monmap_status", adminNode.getNodeName());
//        Map map2 = restTemplate.postForObject(url, query_monmap_status, Map.class);

        HashMap<String, Object> result = new HashMap<>();
        if(map.get("msg").toString().equals("SUCCESS")){
            result.put("err", "");
            result.put("msg", map.get("msg"));
            JSONObject context = JSON.parseObject(map.get("context").toString());
            String[] FilterItems = {"quorum_age", "monmap"};
            String s = jsonString(FilterItems, context, false);
            System.out.println(s);
            result.put("data", JSON.parseObject(s));
        }
        return result;
    }
}
