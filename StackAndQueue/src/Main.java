package StackAndQueue.src;

import StackAndQueue.src.InfixPostfixPrefix.InfixToPrefix;

public class Main {
    static void main(String[] args) {
        TrappingRainwater trappingRainwater = new TrappingRainwater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappingRainwater.trap(height));
    }
}
