# Online Shopping UAT Checklist

| User scenario | Expected result | Pass/Fail |
|---|---|---|
| Add an available product to the cart | Product appears in cart | |
| Add two products | Total equals the sum of both prices | |
| Check out with available stock | Order status is `CONFIRMED` | |
| Check out with an out-of-stock product | A clear out-of-stock error appears | |
| Check out with an empty cart | Checkout is rejected | |

Tester:  
Date:  
Approved: Yes / No

## UI testing

This example is a command-line Java application. Selenium UI testing is not
included because there is no webpage yet. It can be added after a web interface
with product fields, cart buttons, and a checkout button is created.
