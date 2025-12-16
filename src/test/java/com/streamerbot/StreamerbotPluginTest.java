package com.streamerbot;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class StreamerbotPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(StreamerbotPlugin.class);
		RuneLite.main(args);
	}
}