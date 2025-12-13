# Sugar & Stone Ordering Application

## Overview

This repository now includes a **separate web application** for Sugar & Stone, an artisan bakery and desserts ordering system. This is completely independent from the main FEM Android application.

## Location

📂 **Directory**: `/sugar-and-stone/`

This is a standalone web application that can be deployed independently or accessed locally.

## What is Sugar & Stone?

Sugar & Stone is a complete e-commerce ordering application for a bakery/dessert business with the following features:

### ✨ Key Features

- **20 Menu Items** across 4 categories:
  - 🎂 Cakes (Chocolate Fudge, Red Velvet, Vanilla Bean, Carrot, Lemon Drizzle)
  - 🥐 Pastries (Croissants, Pain au Chocolat, Danish, Tarts, Eclairs)
  - ☕ Beverages (Cappuccino, Latte, Iced Coffee, Hot Chocolate, Fresh Juice)
  - 🍰 Desserts (Tiramisu, Cheesecake, Brownies, Macarons, Panna Cotta)

- **Shopping Cart System**:
  - Add/remove items
  - Update quantities
  - Real-time cart count
  - Persistent cart (localStorage)

- **Order Processing**:
  - Customer details form with validation
  - WhatsApp integration for order submission
  - Order confirmation display

- **Modern UI/UX**:
  - Professional bakery theme
  - Fully responsive (mobile, tablet, desktop)
  - Search and filter functionality
  - Modal-based cart
  - Toast notifications

### 🛠️ Technology

- **Pure HTML, CSS, JavaScript** - No frameworks required
- **WhatsApp Web API** - Direct order submission
- **localStorage API** - Cart persistence
- **Single-page application** - No backend needed

## Quick Start

### Option 1: Open Directly
```bash
cd sugar-and-stone
# Open index.html in any web browser
```

### Option 2: Local Server
```bash
cd sugar-and-stone
python3 -m http.server 8000
# Visit http://localhost:8000
```

### Option 3: Deploy
Upload the `sugar-and-stone/` folder to any web hosting service:
- GitHub Pages
- Netlify
- Vercel
- Traditional web hosting

## Configuration

Before using in production, update the WhatsApp business number in `sugar-and-stone/index.html` (line 1224):

```javascript
const whatsappNumber = '1234567890'; // Replace with your number
```

Use international format without + or spaces:
- US: +1 (555) 123-4567 → `15551234567`
- UK: +44 20 1234 5678 → `442012345678`

## Documentation

See `/sugar-and-stone/README.md` for:
- Complete feature documentation
- Configuration guide
- Menu customization
- Deployment instructions
- Browser compatibility
- Troubleshooting

## Screenshots

### Desktop View
![Desktop View](https://github.com/user-attachments/assets/0c594648-ec23-44b5-ae77-f94879a50507)

### Mobile View
![Mobile View](https://github.com/user-attachments/assets/b12735ef-e931-459d-86c3-d0e031b68402)

## Why is this in the FEM repository?

This is a **separate application** that has been added to the FEM_Main repository as requested. It is completely independent and can be:
- Used as-is for a bakery business
- Deployed separately
- Customized for any food ordering business
- Extracted to its own repository

## Relationship to FEM

| Aspect | FEM App | Sugar & Stone |
|--------|---------|---------------|
| **Type** | Android Native App | Web Application |
| **Technology** | Kotlin, Android SDK | HTML, CSS, JavaScript |
| **Purpose** | Women's empowerment app | Bakery ordering system |
| **Platform** | Android devices | Any web browser |
| **Location** | `/app/` directory | `/sugar-and-stone/` directory |

## Status

✅ **Production Ready**

The application is complete and fully functional with:
- All features implemented
- Mobile-responsive design
- Form validation
- Cart persistence
- WhatsApp integration
- Comprehensive documentation
- Tested on multiple browsers

## Support

For Sugar & Stone specific issues or questions:
1. Check `/sugar-and-stone/README.md`
2. Verify WhatsApp configuration
3. Test in modern browsers (Chrome 90+, Firefox 88+, Safari 14+)

---

**Created**: December 2025  
**Version**: 1.0.0  
**Status**: Complete ✅
