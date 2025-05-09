# 📦 Parcel Management System

A Java-based desktop application to manage parcel deliveries and track courier operations. Built using **Java Swing** and **AWT**, this project simulates a full-fledged parcel management solution with user authentication, order placement, tracking, and admin functionalities.

---

## ✨ Features

- 🔐 **Login/Signup System** with password reset and validation
- 📬 **Place Orders** with sender/receiver details and cost calculation
- 📊 **Dashboard** for tracking and managing orders
- 👁️ **Order & User Viewing** panels for admin
- 💵 **Payment Simulation** (e.g., Paytm integration logic)
- 🔄 **Update/Delete User Info**
- 📦 **Track Orders in Real Time**
- 🖼️ **GUI** powered by **Java Swing** and **AWT**
- 🧾 **Terms, Support & About** sections included

---

## 🗂️ Project Structure

.
├── Login.java # Handles user authentication
├── Signup.java # New user registration
├── Dashboard.java # Main admin/user dashboard
├── PlaceOrder.java # Order placement interface
├── TrackOrder.java # Real-time order tracking
├── Payment.java / Paytm.java# Payment integration logic
├── AddUserDetails.java # Add user info
├── ViewOrders.java # Admin view for placed orders
├── UpdateUserDetails.java # Edit user information
├── DeleteUserDetails.java # Remove user accounts
├── ReceiverDetails.java # Details for parcel recipient
├── CourierType.java # Type selection for courier
├── CalcCost.java # Calculate parcel delivery cost
├── ForgetPassword.java # Password reset flow
├── Support.java / About.java/ Terms.java # Informational screens
└── Conn.java # Database connection logic

yaml
Copy
Edit

---

## 🛠️ Technologies Used

- **Java 8+**
- **Swing**
- **AWT**
- **JDBC** 
---

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) installed
- IDE like IntelliJ IDEA or Eclipse
- (Optional) MySQL or any backend DB if connection is implemented

### Running the App

1. Clone the repo:
   ```bash
   git clone https://github.com/Adityap616/ParcelManagementSystem.git
   cd ParcelManagementSystem
Open the project in your preferred Java IDE.

Compile and run the Login.java or Dashboard.java file to launch the application.

🧪 Sample Flow
Signup → Login

Place Parcel Order

Enter Sender & Receiver Info

Calculate Cost → Make Payment

Track Order Status

Admin Dashboard for full visibility

📌 Notes
GUI is entirely built with Java Swing and AWT for simplicity.

You can link a real database or use mock data as needed.

Designed to be extended into a larger parcel/courier ERP system.

📄 License
This project is licensed under the MIT License.

🙌 Acknowledgements
Thanks to the open-source Java community and resources that inspired the UI components and architecture logic.
