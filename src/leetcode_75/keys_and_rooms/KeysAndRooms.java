package leetcode_75.keys_and_rooms;

import java.util.HashSet;
import java.util.List;

public class KeysAndRooms {


    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);

        for (boolean roomVisited : visited) {
            if (!roomVisited) return false;
        }

        return true;
    }

    private void dfs(List<List<Integer>> rooms, int current, boolean[] visited) {
        if (visited[current]) return;

        visited[current] = true;

        for (int nextRoom : rooms.get(current)) dfs(rooms, nextRoom, visited);

    }
}




