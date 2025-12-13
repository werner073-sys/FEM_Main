# Sugar & Stone - Home Cooked Meals Ordering App

A modern, mobile-responsive web application for ordering delicious home-cooked South African meals. Orders are placed directly through WhatsApp for seamless communication.

## Features

### 🍛 Complete Menu System
- **Bobotie**: Traditional South African curried mince (1kg, 500g, 250g)
- **Curry & Rice**: Aromatic curry with basmati rice (1kg, 500g, 250g)
- **Chicken Briyani**: Fragrant rice with spiced chicken (1kg, 500g, 250g)
- **Spaghetti Bolognese**: Classic Italian pasta (1kg, 500g, 250g)
- **Beef Lasagne**: Layered pasta with rich beef sauce (1kg, 500g, 250g)
- **Chicken Lasagne**: Creamy chicken lasagne (1kg, 500g, 250g)
- **Country Chicken Pie**: Hearty chicken pie (2kg, 1kg, 500g, 250g)

All items available in multiple sizes with prices in South African Rand (R)

### 🛒 Shopping Cart Functionality
- Add items to cart with a single click
- Update quantities easily with +/- controls
- Remove items from cart
- Real-time cart count display
- Persistent cart using localStorage (survives page refreshes)

### 📱 Order Processing
- Customer details form with validation
- Full name, phone number, and delivery address required
- Optional special instructions field
- Formatted order details sent via WhatsApp
- Order confirmation display

### 🎨 Professional UI/UX
- Clean, elegant design with warm color palette (browns, golds, cream)
- Smooth animations and transitions
- Toast notifications for user feedback
- Modal-based cart interface
- Multiple sizes displayed for each meal

### 🔍 Search & Filter
- Real-time search by item name or description
- Category filtering (All Items, Traditional, Curries, Pasta, Pies)
- "No results" message when nothing matches

### 📱 Mobile Responsive
- Works perfectly on phones, tablets, and desktops
- Touch-friendly controls
- Adaptive layout for different screen sizes

## Technology Stack

- **HTML5**: Semantic markup
- **CSS3**: Modern styling with flexbox and grid
- **Vanilla JavaScript**: No frameworks required
- **localStorage API**: Cart persistence
- **WhatsApp Web API**: Order submission

## Installation & Usage

### Option 1: Direct Browser Access
1. Simply open `index.html` in any modern web browser
2. No server or build process required
3. Works offline (except for WhatsApp submission)

### Option 2: Local Development Server
```bash
# Using Python 3
python -m http.server 8000

# Using Node.js (http-server)
npx http-server

# Using PHP
php -S localhost:8000
```

Then open http://localhost:8000 in your browser.

### Option 3: Deploy to Web Hosting
Upload the entire `sugar-and-stone` directory to any web hosting service:
- GitHub Pages
- Netlify
- Vercel
- Traditional web hosting (cPanel, etc.)

## Configuration

### WhatsApp Business Number

To receive orders, update the WhatsApp business number in `index.html`:

```javascript
// Line 1224 in the submitOrder() function
const whatsappNumber = '1234567890'; // Replace with your actual WhatsApp number
```

**Format**: Use international format without + or spaces
- Example: For South Africa +27 (82) 123-4567 use: `27821234567`
- Example: For US +1 (555) 123-4567 use: `15551234567`
- Example: For UK +44 20 1234 5678 use: `442012345678`

### Menu Items

Menu items are defined in the `menuData` array in `index.html`. Each item has:
- `id`: Unique identifier
- `name`: Item name (e.g., "Bobotie", "Curry & Rice")
- `size`: Size portion (e.g., "1kg", "500g", "250g")
- `description`: Item description
- `price`: Price in South African Rand (no decimals, e.g., 200 for R200)
- `category`: One of: traditional, curries, pasta, pies
- `emoji`: Icon to display (fallback if image not available)
- `image`: Path to food photo (e.g., "assets/images/bobotie.jpg")

To add/edit items, modify the `menuData` array (starts at line 809).

### Adding Food Photography Images

The application is configured to use high-quality food photos:
1. Add image files to `assets/images/` directory
2. Required images: `bobotie.jpg`, `curry-rice.jpg`, `chicken-briyani.jpg`, `spaghetti-bolognese.jpg`, `beef-lasagne.jpg`, `chicken-lasagne.jpg`, `chicken-pie.jpg`
3. Recommended: 800x600px or larger, JPG/PNG/WebP format, under 300KB each
4. See `assets/images/README.md` for detailed specifications and tips

**Fallback**: If images are not available, emoji icons will display automatically.

## Features in Detail

### Shopping Cart
- **Add to Cart**: Click "Add to Cart" button on any menu item
- **View Cart**: Click the cart button in the header
- **Update Quantity**: Use +/- buttons in the cart
- **Remove Items**: Click "Remove" button
- **Cart Persistence**: Cart is saved to browser localStorage

### Order Submission
1. Add items to cart
2. Click "Cart" button in header
3. Fill in customer details (name, phone, address)
4. Add special instructions (optional)
5. Click "Place Order via WhatsApp"
6. WhatsApp opens with pre-formatted order message
7. Send message to complete order

### Search & Filter
- **Search**: Type in search bar and press Enter or click 🔍
- **Filter**: Click category buttons to show only items in that category
- **Combine**: Search works within selected category

## File Structure

```
sugar-and-stone/
├── index.html          # Complete single-page application
└── README.md           # This file
```

## Browser Compatibility

- ✅ Chrome 90+
- ✅ Firefox 88+
- ✅ Safari 14+
- ✅ Edge 90+
- ✅ Mobile browsers (iOS Safari, Chrome Mobile)

## Customization Guide

### Colors
Edit CSS variables in the `:root` section (lines 14-22):
```css
:root {
    --primary-color: #8B4513;      /* Main brown */
    --secondary-color: #D2691E;    /* Light brown */
    --accent-color: #FFD700;       /* Gold */
    --light-bg: #FFF8DC;           /* Cream background */
    /* ... more colors ... */
}
```

### Business Information
Update the business name in the header (line 585):
```html
<div class="logo">
    Sugar <span>&</span> Stone
</div>
```

### Menu Categories
To add a new category:
1. Add button in HTML (line 606)
2. Add items with that category in `menuData`
3. No other changes needed!

## Testing

### Manual Testing Checklist
- [ ] Browse all menu items
- [ ] Test category filters
- [ ] Test search functionality
- [ ] Add items to cart
- [ ] Update item quantities
- [ ] Remove items from cart
- [ ] Test cart persistence (refresh page)
- [ ] Test form validation (empty fields)
- [ ] Submit test order via WhatsApp
- [ ] Test on mobile device
- [ ] Test on different browsers

## Security & Privacy

- No personal data is stored on servers
- Cart data is stored locally in browser only
- All order data goes directly to WhatsApp
- No backend database or API required
- No user tracking or analytics

## Support

For issues or questions:
1. Check this README for configuration help
2. Verify WhatsApp number is correctly formatted
3. Ensure JavaScript is enabled in browser
4. Check browser console for error messages

## License

This is a standalone web application. Use and modify as needed for your business.

## Credits

Created as a complete ordering solution for bakery and dessert businesses.

---

**Version**: 1.0.0  
**Last Updated**: December 2025  
**Status**: Production Ready ✅
