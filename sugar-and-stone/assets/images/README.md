# Images Directory

This directory is for storing menu item images if you want to replace the emoji icons with actual product photos.

## Usage

1. Add your product images here (JPG, PNG, WebP formats recommended)
2. Update the menu items in `index.html` to reference the images:

```javascript
{
    id: 1,
    name: "Chocolate Fudge Cake",
    description: "Rich, moist chocolate cake...",
    price: 45.00,
    category: "cakes",
    image: "assets/images/chocolate-cake.jpg"  // Add this property
}
```

3. Update the rendering code to use images instead of emojis:

```javascript
// Replace line ~734
<div class="menu-item-image">
    ${item.image ? `<img src="${item.image}" alt="${item.name}">` : item.emoji}
</div>
```

## Recommended Image Specifications

- **Format**: JPG or WebP for photos
- **Dimensions**: 600x600px (square, will be cropped to fit)
- **File Size**: Keep under 200KB per image for fast loading
- **Naming**: Use lowercase with hyphens (e.g., `chocolate-cake.jpg`)

## Optimization Tips

- Use image compression tools like TinyPNG or ImageOptim
- Consider WebP format for better compression
- Add loading="lazy" attribute for better performance
