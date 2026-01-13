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
2. Connect your Streamerbot to your broadcasting software and streaming platform(s) of choice, using
   the [Initial Setup Guide](https://docs.streamer.bot/get-started/setup).
3. Set up your Streamerbot to receive HTTP
   requests: [HTTP Server Configuration guide](https://docs.streamer.bot/api/http/guide/configuration). You can leave
   the  **Address** as the default `127.0.0.1`.
   and the **Port** as the default `7474` for our use case, unless you have to use a different address for some reason.
   Enable **Auto Start** for future use and simply press `⏻ Start Server`. Your Streamerbot server is now running.
4. Build an action that you want Streamerbot to execute upon an in-game event. The name you will give to this action
   will be important for later.
   For an explanation on how to do this,
   [click here](https://docs.streamer.bot/guide/actions).

<sub> Note: Normally, actions in Streamerbot require a trigger to 
execute them on given events. In our case, this is not needed, since the HTTP server we just set up simply executes 
the action on an incoming request. </sub>

Your Streamerbot is now set up to perform the action upon receiving an HTTP request from an external source, 
which in our case is the Streamerbot plugin in RuneLite. 

### Setting up Streamerbot Plugin

Install and enable the Streamerbot plugin from the Plugin Hub. Unless either your Streamerbot application uses a
nondefault address or you're sending requests to a remote instance of Streamerbot, leave `Streamerbot address` as the
default `http://127.0.0.1:7474`. Enable your notifier of choice and copy the exact name
of your action in Streamerbot (not case-sensitive) to the `action name` field corresponding to your chosen notifier.

### Setting up Dink

Currently, all notifiers of the Streamerbot plugin rely on Dink notifiers.

Install Dink from the Plugin Hub and enable the notifier corresponding to the one enabled in the Streamerbot plugin.
The Streamerbot plugin receives Dink's notifications whenever Dink would normally notify a Discord
webhook. You can therefore set the conditions for the notifier through the settings in Dink. If you already had
Dink installed, the notifier in Dink corresponding to the one you enabled in the Streamerbot plugin is enabled
automatically, but you will still have to configure its notify conditions.

<sub> Some Dink notifiers, like the Collection Log notifier, require you to configure in-game settings in addition. 
Dink will send a warning in game chat when this is the case. </sub>

Your Streamerbot action triggered on in-game events is now complete. Whenever the configured event takes place in
your game instance, your Streamerbot action will be executed. This basic setup serves to give you a broad idea of
how this plugin should be used with Streamerbot and your streaming ecosystem. If you'd like to see a more
concrete example, see the [Example notifier](#example-notifier), where you can build your first fully functioning game
event-based alert.

### Example notifier

<details>

<summary>Click here to open the tutorial</summary>

In this example we will build a notifier that plays the iconic 'YOU DIED' animation inside OBS Studio whenever your
in-game character dies. You can download `YOU DIED.mov` from the `resources` folder in this plugin's repository. 

**Note:** For this tutorial you must have your Streamerbot application connected to your OBS Studio. If you haven't
done this already, please follow these [steps](https://docs.streamer.bot/get-started/setup#obs-studio). A status
indicator in the top-right corner of the Streamerbot window will light
up green 🟢 once this is done successfully. Additionally, the HTTP server in your Streamerbot must be enabled.
Refer to step 3. of [Setting up Streamerbot](#setting-up-streamerbot)

#### In OBS Studio setup

1. Go to the OBS scene where you keep your other alert sources. Inside the list of sources right-click
   `Add Source > Media Srouce`. Give this a name. In our example we name it `You died`. Navigate to the file
   `YOU DIED.mov`. Make sure to check 'Restart playback
   when source becomes active' ✅. Click 'OK'.

<sub>
It is best practice to organize your alert overlays by scene nesting, but that's outside the scope of this tutorial. 
</sub>

![OBS1](resources/OBS1.png)
![OBS2](resources/OBS2.png)
![OBS3](resources/OBS3.png)

2. Like all alert overlays, make sure this media source is above your RuneLite source. If you want to be able to hear
   this alert, right-click the
   **Audio Mixer** and select `Advanced Audio Properties` and make sure your added media source has 'Monitor and
   Output'
   as the **Audio Monitoring** option. Once that's done, click the eye icon to hide it . You will see later why.

![OBS4](resources/OBS4.png)

![OBS5](resources/OBS5.png)

![OBS6](resources/OBS6.png)

#### Streamerbot setup

1. In your Streamerbot application, navigate to ``Actions & Queues > Actions``, right-click the 'Actions' container and 
click `Add`. Give it a name. In our example, we will name it `Death`. Optionally, you can assign it to a group to keep 
it organized.

![Streamerbot1.png](resources/Streamerbot1.png)
![Streamerbot2.png](resources/Streamerbot2.png)

2. Select the action you just made. The 'Sub-Actions' container will list the tasks this action will perform in the
   order shown.
   Here, right-click `Add > Core > Delay` and set it to `600` milliseconds and click 'Ok'. This sub-action simply lets
   Streamerbot wait before performing the next sub-action. In our case, this is to time the animation nicely with
   the in-game death.

![Streamerbot3.png](resources/Streamerbot3.png)
![Streamerbot4.png](resources/Streamerbot4.png)

3. Now right-click `Add > OBS Studio > Sources > Set Source Visibility State`. Select your OBS scene where you added
   the media source and then select the source itself, which we named `You died`. Set the state to `Visible` and click '
   Ok'.

![Streamerbot5.png](resources/Streamerbot5.png)

4. Right-click your 'Delay for 600ms' sub-action and select `Duplicate Sub-Action`, which adds another identical
   sub-action at the end of the sequence. Double-click this copy to edit it. Set the delay to `8500` milliseconds and
   click 'Ok'. This second delay is to let the animation play before proceeding. Similarly, duplicate your 'OBS Studio
   Source Visibility State' sub-action and change the state to `Hidden`. You now have created an action which. The
   result should look like in the image below.

![Streamerbot6.png](resources/Streamerbot6.png)

<sub>Don't worry if your scene and source are named differently.</sub>

You now have created a Streamerbot action that: 
- waits 600ms
- makes a media source visible, which automatically plays the media file
- waits another 8500ms to let it play
- hides the media source again

#### Setup in RuneLite

1. Ensure Dink and the Streamerbot plugin are installed from the Plugin Hub and enabled.

2. In your RuneLite settings go to `Streamerbot > Dink notifications > Enable death` and checkmark this setting. This 
will automatically enable the corresponding notifier in Dink. below, copy the name of the action you created, which in our example was `Death`. 
By default, Dink's death notifier will ignore safe deaths. If you do want the alert to play on safe death, go to 
`Dink > Death > Ignore Safe Deaths` and uncheck this setting. In this section, you can customize exactly when the 
death notifier fires. Some of these settings, such as `Send Image` and `Embed Kept Items` can be ignored, as they're 
only relevant for sending notifications to Discord webhooks with Dink.

Your death alert should now be ready to use! The result should look like this in OBS Studio.

[![Example](https://img.youtube.com/vi/0YfdTtCFP4Q/0.jpg)](https://www.youtube.com/watch?v=0YfdTtCFP4Q)

</details>

### Data

When a notifier fires, data relevant to the in-game event is sent alongside the notification to Streamerbot. In the
spirit of Streamerbot, we shall refer to the data as 'variables'. All notifiers will send the variables `notificationType`
indicating the type of event, `playerName`, `accountType` and
`plainText`, which is the message configured within Dink, besides their individual dataset.
For example, on player death the death notifier sends the integer `valueLost`, indicating how much wealth
in gp the player lost. It also sends the boolean `isPvp`, which has the value `true` if another player killed the user
and `false` otherwise, and the string `killerName`, indicating who or what npc killed you (when applicable),
among other variables.

On certain events, some variables cannot have a meaningful value. For example if your character dies without being 
killed by a player or npc, `killerName` will simply have the value "N/A". Other nullable string variables will also 
have this behavior. 

For a full overview of the variables that's sent with each notifier, see
Dink's [JSON examples](https://github.com/pajlads/DinkPlugin/blob/master/docs/json-examples.md). Of each notifier, its 
unique dataset is contained inside `"extra"`.

With each notifier, you can use the included data get really creative! 

## Credits and Attribution
