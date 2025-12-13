# Images Directory

This directory is for storing high-quality food photography images for your menu items.

## Required Images

The application is now configured to use actual food photos. Add the following image files to this directory:

1. **bobotie.jpg** - Traditional South African Bobotie (curried mince with egg topping)
2. **curry-rice.jpg** - Aromatic curry served with basmati rice
3. **chicken-briyani.jpg** - Fragrant chicken briyani with spices
4. **spaghetti-bolognese.jpg** - Classic Italian spaghetti with meat sauce
5. **beef-lasagne.jpg** - Layered beef lasagne with cheese
6. **chicken-lasagne.jpg** - Creamy chicken lasagne
7. **chicken-pie.jpg** - Country chicken pie with golden pastry

## Image Specifications

### Recommended Specifications
- **Format**: JPG, PNG, or WebP
- **Dimensions**: 800x600px or larger (will be cropped to fit)
- **Aspect Ratio**: 4:3 or close (landscape orientation works best)
- **File Size**: Keep under 300KB per image for fast loading
- **Quality**: High-quality food photography with good lighting

### Naming Convention
Use the exact filenames listed above (lowercase with hyphens):
- ✅ `bobotie.jpg`
- ✅ `curry-rice.jpg`
- ❌ `Bobotie.JPG`
- ❌ `curry_rice.png`

## How to Get Quality Food Photos

### Option 1: Take Your Own Photos
- Use natural lighting or soft artificial light
- Style the food attractively with garnishes
- Use a plain background or wooden surface
- Take photos from a 45° angle or directly above
- Focus on making the food look appetizing

### Option 2: Stock Photography
Free stock photo sites (with attribution where required):
- [Unsplash](https://unsplash.com/) - Search for "South African food" or specific dishes
- [Pexels](https://pexels.com/) - Free high-quality food photos
- [Pixabay](https://pixabay.com/) - Free images for commercial use

Paid stock photo sites:
- [Shutterstock](https://shutterstock.com/)
- [Adobe Stock](https://stock.adobe.com/)
- [iStock](https://istockphoto.com/)

### Option 3: Professional Food Photographer
Hire a local food photographer for custom, high-quality photos of your actual meals.

## Image Optimization

Before adding images, optimize them for web:

### Online Tools
- [TinyPNG](https://tinypng.com/) - Compress PNG and JPG
- [Squoosh](https://squoosh.app/) - Advanced image optimization
- [Optimizilla](https://imagecompressor.com/) - Bulk image compression

### Desktop Tools
- [ImageOptim](https://imageoptim.com/) (Mac)
- [FileOptimizer](https://sourceforge.net/projects/nikkhokkho/) (Windows)
- [Trimage](https://trimage.org/) (Linux)

## How Images Are Used

The application will:
1. Display images as 200px tall cards on the main menu
2. Show images as 80x80px thumbnails in the shopping cart
3. Automatically fall back to emoji icons if an image fails to load
4. Scale and crop images to fit (using `object-fit: cover`)

## Testing Your Images

After adding images:
1. Open `index.html` in a web browser
2. Check that all images load correctly
3. Verify images look good on both desktop and mobile
4. Ensure images don't take too long to load

## Fallback Behavior

If an image file is missing or fails to load:
- The application will automatically display the emoji icon instead
- This ensures the site always looks complete even without photos
- No error messages will be shown to users

## Current Status

✅ **Code Updated**: The application is ready to use images
⚠️ **Images Pending**: Add your food photos to see them in the app
📝 **Image paths configured** in `index.html` at line 809+

Once you add the image files listed above, they will automatically appear in the application!
