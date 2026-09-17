# Online Shopping Testing Demo

This is a completely different example from the calculator. A customer adds
products to a cart, inventory is checked, and an order is confirmed.

## Separate testing files

| File | Type | What it checks |
|---|---|---|
| `ShoppingCartUnitTest.java` | Unit | Cart total and input validation |
| `OrderServiceIntegrationTest.java` | Integration | Order service and inventory together |
| `CheckoutFunctionalTest.java` | Functional | Complete checkout requirements |
| `ShoppingApplicationSystemTest.java` | System | Entire command-line application |
| `docs/UAT-CHECKLIST.md` | UAT | Manual customer acceptance scenarios |

## Run in VS Code

Open this folder, open the terminal, and run:

```powershell
mvn clean test
```

Run one type at a time:

```powershell
mvn -Dtest=ShoppingCartUnitTest test
mvn -Dtest=OrderServiceIntegrationTest test
mvn -Dtest=CheckoutFunctionalTest test
mvn -Dtest=ShoppingApplicationSystemTest test
```

## Connect to GitHub

Create an empty GitHub repository named `online-shopping-testing-demo`, then run:

```powershell
git init
git branch -M main
git add .
git commit -m "Create online shopping testing demo"
git remote add origin https://github.com/YOUR_USERNAME/online-shopping-testing-demo.git
git push -u origin main
```

GitHub Actions automatically runs all tests after every push and pull request.
