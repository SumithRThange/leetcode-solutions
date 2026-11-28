class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int c = image[sr][sc];
        if(c == color) return image;
        floodfill(image, sr, sc, color, c);
        return image;
    }
    private void floodfill(int[][] image, int sr, int sc, int color, int c){
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != c)
        return;

        image[sr][sc] = color;
        
        floodfill(image, sr+1, sc, color, c);
        floodfill(image, sr-1, sc, color, c);
        floodfill(image, sr, sc+1, color, c);
        floodfill(image, sr, sc-1, color, c);
    }
}