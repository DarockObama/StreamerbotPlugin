# Streamerbot Plugin
Let your stream play the iconic 'YOU DIED' animation when your character dies, have your Twitch chatbot keep track of 
your boss kill counts or set up something simple like a death count tracker overlay.

This plugin lets OldSchool RuneScape interact with your stream. It does this by
letting [Streamerbot](https://streamer.bot/) perform actions
through HTTP requests upon events happening in the game, using notifiers
from [Dink](https://github.com/pajlads/DinkPlugin/tree/master).

## What is Streamerbot?

Streamerbot is a versatile, locally run and open-source tool used for streaming. It connects various streaming
platforms such as Twitch, broadcasting software like OBS, among many other integrations to perform
automated tasks for your streams. You can think of use cases such as:

- Sending messages to Twitch Chat with your own chatbot
- Controlling OBS Studio to play your own alerts locally
- Posting messages to Discord
- Playing text-to-speech Audio with [Speaker.bot](https://speaker.bot/)
- Running custom C# code to perform more advanced tasks

In a nutshell, you can enhance your streams with endless room for creativity. If you're new to Streamerbot, it is
recommended to know the basic principles of this
application. [Click here](https://docs.streamer.bot/get-started/introduction) to learn about what it does and how it
works.

## Basic Setup

Using this plugin with Streamerbot requires both the Streamerbot application with an active HTTP Server and the 
Dink Plugin to be running. 

### Setting up Streamerbot

1. Download and install the Streamerbot application, using
   the [Installation Guide](https://docs.streamer.bot/get-started/installation).
2. Connect your Streamerbot to your broadcasting software and streaming platform of choice, using
   the [Initial Setup Guide](https://docs.streamer.bot/get-started/setup).
3. Set up your Streamerbot to receive HTTP
   requests: [HTTP Server Configuration guide](https://docs.streamer.bot/api/http/guide/configuration). You can leave
   the  **Address** as the default `127.0.0.1`
   and the **Port** as the default `7474` for our use case, unless you have to use a different address for some reason.
4. Build an action that you want Streamerbot to execute upon an in-game event. The name you will give to this action
   will be important for later.
   For an explanation on how to do this,
   [click here](https://docs.streamer.bot/guide/actions). For a beginner-friendly tutorial for building your first fully functioning action in
   Streamerbot, see the [Example notifier](#example-notifier).

<sub> Note: Normally, actions in Streamerbot require a trigger to 
execute them on given events. In our case, this is not needed, since the HTTP server we just set up simply executes 
the action on an incoming request. </sub>

Your Streamerbot is now set up to perform the action upon receiving an HTTP request from an external source, 
which in our case is the Streamerbot plugin in RuneLite. 

### Setting up Streamerbot Plugin

Install and enable the Streamerbot plugin from the Plugin Hub. Unless either your Streamerbot application uses a
nondefault address or you're sending requests to a remote instance of Streamerbot, leave `Streamerbot address` as the
default `http://127.0.0.1:7474`. Enable your notifier of choice and copy the exact name
of your action in Streamerbot to the `action name` field corresponding to your chosen notifier.

### Setting up Dink
Currently, all notifiers of the Streamerbot plugin rely on Dink notifiers.

Install Dink from the Plugin Hub and enable the notifier corresponding to the one enabled in the Streamerbot plugin. 
The Streamerbot plugin receives Dink's notifications whenever Dink would normally notify a Discord
webhook. You can therefore set the conditions for the notifier through the settings in Dink. If you already had
Dink installed, the notifier in Dink corresponding to the one you enabled in the Streamerbot plugin is enabled
automatically, but you will still have to configure its notify conditions.

<sub> Some Dink notifiers, like the Collection Log notifier, require you to configure some in-game settings. Dink will 
display a warning in game chat when this is the case. </sub>

### Example notifier
In this example we want to build a notifier that plays the iconic 'YOU DIED' animation inside OBS whenever your 
in-game character dies. Go to  folder of this plugin's repository. 


### Metadata

## Credits and Attribution
