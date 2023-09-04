import java.io.*;

class Thiseas {
    public static void main(String[] args) throws IOException {

        int n;
        int m;
        int x;
        int y;
        boolean found;

        try {
            File file = new File("C://ronaldo//data.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String str = br.readLine();
            String[] parts = str.split(" ");

            n = Integer.parseInt(parts[0]);
            m = Integer.parseInt(parts[1]); // First Line Read

            char[][] a = new char[n][m]; // 2Dim char array creation

            String str2 = br.readLine();
            String[] parts2 = str2.split(" ");

            x = Integer.parseInt(parts2[0]); // Second Line Read
            y = Integer.parseInt(parts2[1]);

            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                String nline = line.replaceAll("\\s", "");
                char[] arr = nline.toCharArray();
                for (int j = 0; j < m; j++) {

                    a[i][j] = arr[j];

                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(a[i][j]); // Typwnei to arxeio pou diavase

                }
                System.out.println();
            }

            if (a[x][y] != 'E')
                System.out.println("Error");
            else {

                StringStackImpl stack = new StringStackImpl(10);

                char left = (x >= 0 && x <= (n - 1) && (y - 1) >= 0 && (y - 1) <= (m - 1)) ? a[x][y - 1] : 'X';
                char right = (x >= 0 && x <= (n - 1) && (y + 1) >= 0 && (y + 1) <= (m - 1)) ? a[x][y + 1] : 'X';
                char bot = ((x + 1) >= 0 && (x + 1) <= (n - 1) && y >= 0 && y <= (m - 1)) ? a[x + 1][y] : 'X';
                char top = ((x - 1) >= 0 && (x - 1) <= (n - 1) && y >= 0 && y <= (m - 1)) ? a[x - 1][y] : 'X';
                char now = (x >= 0 && x <= (n - 1) && y >= 0 && y <= (m - 1)) ? a[x][y] : 'X';

                found = false;
                while (!found) {

                    if (bot == '0' && top != '0' && left != '0' && right != '0') {
                        x++;
                        top = 'X';
                    }
                    if (right == '0' && bot != '0' && left != '0' && top != '0') {
                        y++;
                        left = 'X';
                    }

                    if (left == '0' && bot != '0' && right != '0' && top != '0') {
                        right = 'X';
                        y--;

                    }
                    if (top == '0' && bot != '0' && right != '0' && left != '0') {
                        x--;
                        bot = 'X';

                    }

                    if ((bot != '0' && left != '0' && right != '0' && top != '0') && (x == 0 || x == (n - 1))
                            && (y == 0 || y == (m - 1))) { // Periptwsi Exodou

                        System.out.println(" The exit location is : " + x + ", " + y);
                        found = true;
                    }

                    if (bot != '0' && left != '0' && right != '0' && top != '0') {
                        // Periptwsi pou exw adieksodo

                        String tmp1 = stack.pop();
                        String[] part = tmp1.split(" ");
                        char[] charArray = tmp1.toCharArray();

                        char xn = charArray[0];
                        char yn = charArray[1];
                        now = a[xn][yn];

                    }

                    else { // Periptwsi me panw apo 2 epiloges ston lavyrin8o
                        String tmp = x + " " + y;
                        stack.push(tmp);
                        y--;
                        right = 'X';

                    }

                }

            }

        }

        catch (FileNotFoundException e) {
        }

    }
}
