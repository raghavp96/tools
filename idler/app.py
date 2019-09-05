import pyautogui
import random
import time
import sys



def move_mouse_random():
    screen_width, screen_height = pyautogui.size()[0], pyautogui.size()[1]
    pyautogui.moveTo(random.randint(0, screen_width - 1), random.randint(0, screen_height) - 1, duration = 0)

def scroll_random():
    pyautogui.scroll(random.randint(-200, 200 - 1)) 

actions = [move_mouse_random, scroll_random]

def do_action(duration_sec = 60, wait_sec = 0):
    time_used_sec = 0
    while time_used_sec < duration_sec:
        actions[random.randint(0, len(actions) - 1)]()
        time.sleep(wait_sec)
        time_used_sec += wait_sec

def time_in_sec(time_str):
    last_char = time_str[-1]
    if last_char == 'm':
        time_sec = int(time_str[0: len(time_str) - 1]) * 60
    else:
        time_sec = int(time_str[0: len(time_str) - 1])
    
    return time_sec

def main():
    print("Welcome to Idler!\n")
    print("Idler simulates computer activity by providing IO input to your computer via mouse movements and scrolling.\n")
    print("Specify how long the job should run and how often the mouse should be moved. For 15 seconds, enter \"15s\", and for 15 minutes, enter \"15m\".")
    duration = input("Simulation Duration: ")
    interval = input("Interval: ")

    total_duration_sec = time_in_sec(duration)
    interval_sec = time_in_sec(interval)

    do_action(duration_sec = total_duration_sec, wait_sec = interval_sec)
    

main()