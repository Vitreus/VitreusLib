package com.vitreusmc.lib.database.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.bson.types.ObjectId;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.PostLoad;

import com.vitreusmc.lib.common.Flag;
import com.vitreusmc.lib.common.Milestone;

import net.md_5.bungee.api.ChatColor;

@Entity(value = "players", noClassnameStored = true)
public class VitreusPlayer {
	
	@Id private ObjectId id;
	
	@Indexed(options = @IndexOptions(unique = true)) private UUID uuid;
	@Indexed(options = @IndexOptions(unique = true)) private String username;

	private ArrayList<Flag> flags;
	private ArrayList<Milestone> milestones;
	
	private ChatColor color;
	private Date lastOnline;
	private int minutesPlayed;
	
	public static VitreusPlayer create(Player player) {
		VitreusPlayer vitreusPlayer = new VitreusPlayer();
				
		vitreusPlayer.uuid = player.getUniqueId();
		vitreusPlayer.username = player.getName();
		vitreusPlayer.flags = new ArrayList<Flag>();
		vitreusPlayer.milestones = new ArrayList<Milestone>();
		vitreusPlayer.color = ChatColor.WHITE;
		vitreusPlayer.lastOnline = new Date();
		vitreusPlayer.minutesPlayed = player.getStatistic(Statistic.PLAY_ONE_TICK) / 20 / 60;
		
		return vitreusPlayer;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<Flag> getFlags() {
		return flags;
	}

	public void setFlags(ArrayList<Flag> flags) {
		this.flags = flags;
	}

	public ArrayList<Milestone> getMilestones() {
		return milestones;
	}

	public void setMilestones(ArrayList<Milestone> milestones) {
		this.milestones = milestones;
	}

	public ChatColor getColor() {
		return color;
	}

	public void setColor(ChatColor color) {
		this.color = color;
	}

	public Date getLastOnline() {
		return lastOnline;
	}

	public void setLastOnline(Date lastOnline) {
		this.lastOnline = lastOnline;
	}

	public int getMinutesPlayed() {
		return minutesPlayed;
	}

	public void setMinutesPlayed(int minutesPlayed) {
		this.minutesPlayed = minutesPlayed;
	}

	public ObjectId getId() {
		return id;
	}
	
}
