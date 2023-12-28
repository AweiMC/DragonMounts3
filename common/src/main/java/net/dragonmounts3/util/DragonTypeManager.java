package net.dragonmounts3.util;


import java.util.LinkedHashSet;
import java.util.Set;

public class DragonTypeManager {
    private static final Set<String> dragonTypes = new LinkedHashSet<>();

    static {
        initDefaultTypes();
    }

    private static void initDefaultTypes() {
        dragonTypes.add("aether");
        dragonTypes.add("enchant");
        dragonTypes.add("ender");
        dragonTypes.add("fire");
        dragonTypes.add("forest");
        dragonTypes.add("ice");
        dragonTypes.add("moonlight");
        dragonTypes.add("nether");
        dragonTypes.add("sculk");
        dragonTypes.add("storm");
        dragonTypes.add("sunlight");
        dragonTypes.add("terra");
        dragonTypes.add("water");
    }

    public static synchronized void addDragonType(String type) {
        // 可以在这里进行网络同步，向所有玩家发送新的 DragonType
        dragonTypes.add(type);
    }

    public static synchronized Set<String> getDragonTypes() {
        return new LinkedHashSet<>(dragonTypes);
    }
}
