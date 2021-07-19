package net.mcreator.gratestinventions.procedures;

import net.mcreator.gratestinventions.GratestInventionsModElements;

import java.util.Map;

@GratestInventionsModElements.ModElement.Tag
public class ItemToNameProcedure extends GratestInventionsModElements.ModElement {
	public ItemToNameProcedure(GratestInventionsModElements instance) {
		super(instance, 144);
	}

	public static String executeProcedure(Map<String, Object> dependencies) {
		double laufvariabel = 0;
		double amount = 0;
		String searchedChar = "";
		String fluid = "";
		if ((!(((fluid)).equals("")))) {
			laufvariabel = (double) 0;
			while ((!(((searchedChar)).equals(":")))) {
				searchedChar = (String) ((fluid).substring((int) (laufvariabel), (int) ((laufvariabel) + 1)));
				laufvariabel = (double) ((laufvariabel) + 1);
			}
			searchedChar = (String) ((fluid).substring((int) (laufvariabel), (int) ((fluid)).length()));
			if ((((searchedChar)).equals("empty"))) {
				searchedChar = (String) "None";
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("a"))) {
				searchedChar = (String) (("A") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("b"))) {
				searchedChar = (String) (("B") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("c"))) {
				searchedChar = (String) (("C") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("d"))) {
				searchedChar = (String) (("D") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("e"))) {
				searchedChar = (String) (("E") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("f"))) {
				searchedChar = (String) (("F") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("g"))) {
				searchedChar = (String) (("G") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("h"))) {
				searchedChar = (String) (("H") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("i"))) {
				searchedChar = (String) (("I") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("j"))) {
				searchedChar = (String) (("J") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("k"))) {
				searchedChar = (String) (("K") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("l"))) {
				searchedChar = (String) (("L") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("m"))) {
				searchedChar = (String) (("M") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("n"))) {
				searchedChar = (String) (("N") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("o"))) {
				searchedChar = (String) (("O") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("p"))) {
				searchedChar = (String) (("P") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("q"))) {
				searchedChar = (String) (("Q") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("r"))) {
				searchedChar = (String) (("R") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("s"))) {
				searchedChar = (String) (("S") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("t"))) {
				searchedChar = (String) (("T") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("u"))) {
				searchedChar = (String) (("U") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("v"))) {
				searchedChar = (String) (("V") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("w"))) {
				searchedChar = (String) (("W") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("x"))) {
				searchedChar = (String) (("X") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("y"))) {
				searchedChar = (String) (("Y") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			} else if (((((searchedChar).substring((int) 0, (int) 1))).equals("z"))) {
				searchedChar = (String) (("Z") + "" + (((searchedChar).substring((int) 1, (int) ((searchedChar)).length()))));
			}
		}
		return (searchedChar);
	}
}
