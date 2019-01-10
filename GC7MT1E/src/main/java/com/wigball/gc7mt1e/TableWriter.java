package com.wigball.gc7mt1e;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;

@Component
public class TableWriter implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        int[][] values = new int[16][16];

        values[0][0]  = 10;
        values[0][1]  =  9;
        values[0][7]  = 12;
        values[0][8]  = 16;

        values[1][0]  =  1;
        values[1][5]  =  4;
        values[1][6]  =  2;
        values[1][13] =  6;
        values[1][14] = 13;
        values[1][15] =  3;

        values[2][1]  = 14;
        values[2][2]  =  6;
        values[2][7]  = 11;
        values[2][11] = 15;
        values[2][13] = 10;
        values[2][14] = 16;

        values[3][0]  = 3;
        values[3][3]  = 15;
        values[3][5]  = 16;
        values[3][10] = 6;
        values[3][11] = 10;
        values[3][12] = 11;
        values[3][13] = 8;

        values[4][0]  = 12;
        values[4][6]  = 1;
        values[4][9]  = 7;
        values[4][10] = 16;
        values[4][14] = 15;

        values[5][0]  = 13;
        values[5][2]  = 1;
        values[5][6]  = 5;
        values[5][7]  = 14;
        values[5][9]  = 15;
        values[5][10] = 9;
        values[5][15]  = 11;

        values[6][2]  = 2;
        values[6][7]  = 13;
        values[6][8]  = 12;
        values[6][10] = 1;
        values[6][12] = 10;
        values[6][13] = 9;
        values[6][14] = 3;
        values[6][15] = 4;

        values[7][0]  = 5;
        values[7][1]  = 6;
        values[7][2]  = 14;
        values[7][4]  = 3;
        values[7][5]  = 15;
        values[7][7]  = 16;
        values[7][8]  = 8;
        values[7][14] = 2;

        values[8][1]  = 1;
        values[8][7]  = 10;
        values[8][8]  = 2;
        values[8][10] = 7;
        values[8][11] = 5;
        values[8][13] = 15;
        values[8][14] = 6;
        values[8][15] = 14;

        values[9][0]  = 9;
        values[9][1]  = 7;
        values[9][2]  = 16;
        values[9][3]  = 6;
        values[9][5]  = 12;
        values[9][7]  = 1;
        values[9][8]  = 3;
        values[9][13] = 2;

        values[10][0]  = 14;
        values[10][5]  = 13;
        values[10][6]  = 6;
        values[10][8]  = 11;
        values[10][9]  = 9;
        values[10][13] = 7;
        values[10][15] = 10;

        values[11][1]  = 10;
        values[11][5]  = 5;
        values[11][6]  = 14;
        values[11][9]  = 1;
        values[11][15] = 16;

        values[12][2]  = 5;
        values[12][3]  = 12;
        values[12][4]  = 4;
        values[12][5]  = 1;
        values[12][10] = 3;
        values[12][12] = 14;
        values[12][15] = 6;

        values[13][1]  = 13;
        values[13][2]  = 9;
        values[13][4]  = 2;
        values[13][8]  = 4;
        values[13][13] = 3;
        values[13][14] = 12;

        values[14][0]  = 6;
        values[14][1]  = 2;
        values[14][2]  = 10;
        values[14][9]  = 13;
        values[14][10] = 14;
        values[14][15] = 1;

        values[15][7]  = 5;
        values[15][8]  = 15;
        values[15][14] = 10;
        values[15][15] = 7;

        String[][] colors = new String[16][16];

        colors[1][4]  = "#0000ff";
        colors[13][6] = "#00ff00";
        colors[5][13] = "#00ffff";
        colors[6][9]  = "#ff0000";

        String coords = "<div style=\"text-align: center;\">";

        coords +=     "<span style=\"font-weight: bold; font-size: xx-large;color:"+colors[1][4]+";\">N</span>" +
                      "<span style=\"font-weight: bold; font-size: xx-large;color:"+colors[13][6]+";\">OO</span>" +
                      "<span style=\"font-weight: bold; font-size: xx-large;color:"+colors[5][13]+";\">R</span>" +
                      "<span style=\"font-weight: bold; font-size: xx-large;color:"+colors[6][9]+";\">D</span>";

        colors[15][0] = "#ff00ff";
        colors[0][6]  = "#ffff00";
        colors[9][12] = "#555500";
        colors[13][9] = "#005555";

        coords += "<span style=\"font-weight: bold; font-size: xx-large;color:black;\"> &amp; </span>";

        coords +=     "<span style=\"font-weight: bold; font-size: xx-large;color:"+colors[15][0]+";\">O</span>" +
                      "<span style=\"font-weight: bold; font-size: xx-large;color:"+colors[0][6]+";\">O</span>" +
                      "<span style=\"font-weight: bold; font-size: xx-large;color:"+colors[9][12]+";\">S</span>" +
                      "<span style=\"font-weight: bold; font-size: xx-large;color:"+colors[13][9]+";\">T</span>";

        coords += "</div>";

        StringBuffer out = new StringBuffer();

        out.append("<table width=\"100%\" style=\"text-align:center;\" border=\"1\">");

        for (int y = 0; y < values.length; y++) {
            int[] row = values[y];

            out.append("<tr>");

            for (int x = 0; x < row.length; x++) {

                out.append("<td style\"text-align:center;\">");

                if (row[x] != 0) {
                    out.append(Integer.toHexString(row[x] - 1));
                } else {
                    if (colors[y][x] != null) {
                        out.append("<div style=\"background-color:" + colors[y][x] + ";\">&nbsp;</div>");
                    } else {
                        out.append("&nbsp;");
                    }
                }

                out.append("</td>");
            }

            out.append("</tr>");
        }

        out.append("</table>");

        out.append(coords);

        try {
            PrintWriter pw = new PrintWriter("out.txt");
            pw.write(out.toString());
            pw.flush();
            pw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
