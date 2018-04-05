package com.vitreusmc.lib.common.text;

import net.md_5.bungee.api.ChatColor;

public class Format {

	public static String toFormatted(String content) {
		
		content = content.replace("[i]", ChatColor.ITALIC.toString());
		content = content.replace("[/i]", ChatColor.RESET.toString());
		
		content = content.replace("[b]", ChatColor.BOLD.toString());
		content = content.replace("[/b]", ChatColor.RESET.toString());
		
		content = content.replace("[s]", ChatColor.STRIKETHROUGH.toString());
		content = content.replace("[/s]", ChatColor.RESET.toString());
		
		content = content.replace("[u]", ChatColor.UNDERLINE.toString());
		content = content.replace("[/u]", ChatColor.RESET.toString());
		
		content = content.replace("[@]", ChatColor.MAGIC.toString());
		content = content.replace("[/@]", ChatColor.RESET.toString());
		
		return content;
	}
	
}
