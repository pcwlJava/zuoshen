package com.offer.foundation.class5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author pengcheng
 * @date 2019/3/30 - 20:57
 * @content: 贪心算法：安排最多的宣讲场次
 */
public class BestArrange {

    public class Program{
        public int start;    // 项目开始时间
        public int end;      // 项目结束时间

        public Program(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    /**
     * @param programs ：项目数组
     * @param cur ：当前时间
     * @return ：能够安排的最大项目数
     */
    public int getBestArrange(Program[] programs, int cur){
        // 也可以用堆来做，都一样
        Arrays.sort(programs, new ProgramComparator());
        int res = 0;
        for (int i = 0; i < programs.length; i++) {
            // 只有当前时间早于第i个项目的开始时间时，才可以安排
            if(cur <= programs[i].start){
                res++;   // 安排上了
                cur = programs[i].end;   // 当前时间推移到本次安排项目的结束时间，下个项目的开始时间必须在这个时间之后
            }
        }
        return res;
    }

    // 按照项目的结束时间早来排序，即实现小根堆
    public class ProgramComparator implements Comparator<Program>{
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }
}
