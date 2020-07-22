package com.lhx.cephfs.service.cluster.controller;

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

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public Map<String, Object> QueryClusterStatus(){

        Example example = new Example(Node.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isAdmin", 1);

        Node adminNode = nodeMapper.selectOneByExample(example);

        HashMap<String, Object> body = new HashMap<>();
        HashMap<String, Object> args = new HashMap<>();
        body.put("function", "query_cluster_status");
        args.put("ceph-node", adminNode.getNodename());
        body.put("args", args);

        String url = "http://" + adminNode.getNodeip() + "/command/" ;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url, body, Map.class);
    }
}
