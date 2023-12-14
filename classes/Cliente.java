package classes;

import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa{
	//add client specific atributes
	//OneToOne pedido

	//implement methods for cliente
	void imprimir(String a) {
	}
	
		//add functions for client management
		/*such as:
	RegisterCustomer:
        Description: Adds a new customer to the system.
        Parameters: Customer details such as name, contact information, etc.
        Usage: When a new customer creates an account or places an order for the first time.

    UpdateCustomerDetails:
        Description: Modifies the details of an existing customer.
        Parameters: Customer ID and updated information.
        Usage: When a customer changes their contact information or preferences.

    ViewCustomerDetails:
        Description: Retrieves and displays customer information.
        Parameters: Customer ID or other identifiers.
        Usage: Allows staff to view customer details for order processing or loyalty program management.

    PlaceOrder:
        Description: Records a new order associated with a customer.
        Parameters: Customer ID, order details (items, quantity, etc.).
        Usage: When a customer places an order.

    ViewOrderHistory:
        Description: Retrieves and displays the order history for a customer.
        Parameters: Customer ID.
        Usage: Provides insights into a customer's past orders for personalized service or loyalty rewards.

    ProcessPayment:
        Description: Handles the payment for an order.
        Parameters: Customer ID, order ID, payment details.
        Usage: Initiates the payment process when the customer completes an order.

    ApplyDiscount:
        Description: Applies a discount to a customer's order.
        Parameters: Customer ID, discount code or percentage.
        Usage: Manages special promotions or loyalty rewards for customers.

    DeleteCustomer:
        Description: Removes a customer and their associated data from the system.
        Parameters: Customer ID.
        Usage: When a customer requests account deletion or for administrative purposes.
*/
}
