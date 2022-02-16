package com.leetcode.exercise;

import com.leetcode.exercise.utilities.JSONConverter;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncreaseArrayTest {
    IncreasingArray increasingArray = new IncreasingArray();

    @Disabled
    @Test
    public void testIncreaseArray() {
        assertEquals(1, increasingArray.makeArrayIncreasing(new int[]{1,5,3,6,7}, new int[]{1,3,2,4}));
    }

    @Test
    public void testMerge() {
        assertEquals("[[1,5]]", JSONConverter.convert2DIntArrayToJSON(increasingArray.merge(JSONConverter.convertJSONtoInt2DArray("[[1,4],[4,5]]"))).toString());
        assertEquals("[[0,0],[1,4]]", JSONConverter.convert2DIntArrayToJSON(increasingArray.merge(JSONConverter.convertJSONtoInt2DArray("[[1,4],[0,0]]"))).toString());
        assertEquals("[[1,4]]", JSONConverter.convert2DIntArrayToJSON(increasingArray.merge(JSONConverter.convertJSONtoInt2DArray("[[1,4],[2,3]]"))).toString());
        assertEquals("[[1,10]]", JSONConverter.convert2DIntArrayToJSON(increasingArray.merge(JSONConverter.convertJSONtoInt2DArray("[[2,3],[4,5],[6,7],[8,9],[1,10]]"))).toString());
        assertEquals("[[1,5]]", JSONConverter.convert2DIntArrayToJSON(increasingArray.merge(JSONConverter.convertJSONtoInt2DArray("[[1,4],[1,5]]"))).toString());
    }

    @Test
    public void testInsert() {
        assertEquals("[[1,5],[6,9]]",  JSONConverter.convert2DIntArrayToJSON(increasingArray.insert(JSONConverter.convertJSONtoInt2DArray("[[1,3],[6,9]]"), JSONConverter.convertJSONtoIntArray("[2,5]"))).toString());
        assertEquals("[[1,2],[3,10],[12,16]]",  JSONConverter.convert2DIntArrayToJSON(increasingArray.insert(JSONConverter.convertJSONtoInt2DArray("[[1,2],[3,5],[6,7],[8,10],[12,16]]"), JSONConverter.convertJSONtoIntArray("[4,8]"))).toString());
        assertEquals("[[2,5]]",  JSONConverter.convert2DIntArrayToJSON(increasingArray.insert(JSONConverter.convertJSONtoInt2DArray("[]"), JSONConverter.convertJSONtoIntArray("[2,5]"))).toString());
        assertEquals("[[1,5],[6,8]]",  JSONConverter.convert2DIntArrayToJSON(increasingArray.insert(JSONConverter.convertJSONtoInt2DArray("[[1,5]]"), JSONConverter.convertJSONtoIntArray("[6,8]"))).toString());
    }
}
