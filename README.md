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
   requests: [HTTP Server Configuration guide](https://docs.streamer.bot/api/http/guide/configuration). You can leave the  **Address** as the default `127.0.0.1` 
and the **Port** as the default `7474` for our use case, unless you have to use a different address for some reason. 
4. Build an action that you want Streamerbot to execute upon an in-game event. For a quick tutorial on how to do this, 
[click here](https://docs.streamer.bot/guide/actions). 

<sub> Note: Normally, actions in Streamerbot require a trigger to 
execute them on given events. In our case, this is not needed, since the HTTP server we just set up simply executes 
the action on an incoming request. </sub>

Your Streamerbot is now set up to perform the action upon receiving an HTTP request from an external source, 
which in our case is the Streamerbot plugin in RuneLite. 

### Setting up Streamerbot Plugin

Install and enable the Streamerbot plugin from the Plugin Hub. Unless either your Streamerbot application uses a different
address or you're sending requests to a remote instance of Streamerbot, leave `Streamerbot address` as the default
`http://127.0.0.1:7474`
of Streamerbot. Enable your notifier of choice and copy the exact name
of your action in Streamerbot to the `action name` field corresponding to your chosen notifier.

### Setting up Dink
Although Dink is originally used to send 
notifications to Discord webhooks, it can now also notify other plugins. Install Dink from the Plugin Hub and enable 
the notifier of your choice. The notification is sent to other plugins whenever Dink would normally notify a Discord 
webhook. You can therefore set the conditions for the notifier through the settings in Dink.

<sub> Some Dink notifiers, like the Collection Log notifier, require you to configure some in-game settings. Dink will 
display a warning in game chat when this is the case. </sub>

### Example

### Metadata

## Credits and Attribution
