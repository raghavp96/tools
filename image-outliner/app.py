from PIL import Image, ImageFilter
import os

dir_path = os.path.dirname(os.path.realpath(__file__))

image = Image.open(dir_path + '/your_image.png')
image = image.filter(ImageFilter.FIND_EDGES)
image.save(dir_path + '/new_name.png') 

print("Done")