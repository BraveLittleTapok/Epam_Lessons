package ru.yusdm.stud.lesson_4_oop_continue.j_demo_enums_3;

public class DemoEnums_1 {

    enum TrafficLights {
        GREEN, YELLOW, RED
    }

    private static void demoAllEnumItems_1() {
        for (TrafficLights tl : TrafficLights.values()) {
            System.out.println(tl.name() + " ordinal " + tl.ordinal());
        }
    }

    private static void demoWork_2() {
        TrafficLights tl = TrafficLights.GREEN;

        if (TrafficLights.GREEN.equals(tl)) {
            System.out.println("Go forward");
        } else if (TrafficLights.RED.equals(tl)) {
            System.out.println("Stop");
        }
    }

    private static void demoWork_3() {
        TrafficLights tl = TrafficLights.GREEN;

        if (1 == tl.ordinal()) {
            System.out.println("Go forward");
        } else if (0 == tl.ordinal()) {
            System.out.println("Stop");
        }
    }

    private static  TrafficLights valueOfForEnums_4(String trafficLightAsStr){
        if (trafficLightAsStr.equals(TrafficLights.GREEN.toString())){
            return TrafficLights.GREEN;
        }

        return null;
    }

    private static  TrafficLights valueOfForEnums_5(String trafficLightAsStr){
       return TrafficLights.valueOf(trafficLightAsStr);
    }

    public static void main(String[] args) {
        //demoAllEnumItems_1();
         //demoWork_2();
       // demoWork_3();
        TrafficLights trafficLights = valueOfForEnums_4("GREEN");
        TrafficLights trafficLights2 = valueOfForEnums_4("GREEN_GREEN");
        System.out.println("=====");
        valueOfForEnums_5("GREEN");
        valueOfForEnums_5("GREEN_");
    }
}
