package com.leetcode.exercise.utilities;

import com.leetcode.exercise.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    public String serialize(TreeNode node) {
        if (node == null) return null;
        LinkedList<String> buffer = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            buffer.add(current != null ? Integer.toString(current.val) : null);
            if (current != null) {
                queue.add(current.left);
                queue.add(current.right);
            }
        }

        while (buffer.getLast() == null) {
            buffer.removeLast();
        }
        return "[" + String.join(",", buffer) + "]";
    }

    int index;
    Integer[] nums;
    public TreeNode deserialize(String json) {
        nums = convertJSONtoIntegerArray(json);
        if (nums == null) {
            System.out.println("Incorrect JSON String: " + json);
            return null;
        }
        this.index = 0;
        TreeNode root = new TreeNode(nums[0]);
        recurse(new TreeNode[]{root});
        return root;
    }

    TreeNode[] nodesArray;
    private void recurse(TreeNode[] nodes) {
        nodesArray = new TreeNode[nodes.length * 2];
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != null) {
                if (index >= nums.length - 1) return;
                Integer num = nums[++index];
                nodesArray[i * 2] = num != null ? new TreeNode(num) : null;
                if (num != null) nodes[i].left = nodesArray[i * 2];
                if (index >= nums.length - 1) return;
                num = nums[++index];
                nodesArray[i * 2 + 1] = num != null ? new TreeNode(num) : null;
                if (num != null) nodes[i].right = nodesArray[i * 2 + 1];
            }
        }
        recurse(nodesArray);
    }

    public static Integer[] convertJSONtoIntegerArray(String jsonString) {
        try {
//            JSONArray jsonArray = new JSONArray(jsonString);
//            System.out.println(jsonArray);
            jsonString = jsonString.substring(1, jsonString.length() -1);
            String[] jsonArray = jsonString.split(",");
            Integer[] array = new Integer[jsonArray.length];
            for (int i = 0; i < jsonArray.length; i++) {
                String element = jsonArray[i];
//                array[i] = JSONObject.NULL.equals(jsonArray.get(i)) ? null : (Integer) jsonArray.get(i);
                array[i] = element.equals("null") ? null : Integer.parseInt(element);
            }
            return array;
        } catch (Exception e) {
            System.out.println("Invalid Json String:" + jsonString);
        }
        return null;
    }
}
