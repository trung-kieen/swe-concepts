import { useState } from "react";
import "./App.css";

// Data Layer
export interface Product {
  id: number;
  title: string;
  price: number;
  stock: number;
}

// Data Layer
class ProductInventory {
  products: Product[];

  constructor(products: Product[] = []) {
    this.products = products;
  }

  getProductById(id: number): Product | undefined {
    return this.products.find((product) => product.id === id);
  }

  updateStock(id: number, quantity: number): boolean {
    const product = this.getProductById(id);
    if (product && product.stock >= quantity) {
      product.stock -= quantity;
      return true;
    }
    return false;
  }
}

const mockProducts: Product[] = [
  { id: 1, title: "Laptop", price: 1200, stock: 5 },
  { id: 2, title: "Phone", price: 800, stock: 10 },
];


// Business Logic Layer
class CartController {
  private inventory: ProductInventory;

  constructor(products: Product[] = []) {
    this.inventory = new ProductInventory(products);
  }

  getAll(): Product[] {
    return this.inventory.products;
  }

  addToCart(id: number, quantity: number): boolean {
    return this.inventory.updateStock(id, quantity);
  }
}

// Boundary Class
function App() {
  const [products, setProducts] = useState<Product[]>(mockProducts);
  const [message, setMessage] = useState<string>("");

  const controller = new CartController(products);

  const handleAddToCart = (id: number) => {
    const quantity =parseInt(prompt("Nhập số lượng sản phẩm: ", "1") as string)
    if (!quantity || quantity < 1){
      return
    }
    const success = controller.addToCart(id, quantity);
    if (success) {
      setProducts([...controller.getAll()]);
      setMessage("Thêm vào giỏ hàng thành công!");
    } else {
      setMessage("Sản phẩm đã hết hàng!");
    }
  };

  return (
    <div className="container">
      <h1>Hệ thống mua sắm trực tuyến</h1>
      {message && <p className="message">{message}</p>}
      <table>
        <thead>
          <tr>
            <th>Sản phẩm</th>
            <th>Giá</th>
            <th>Kho hàng</th>
            <th>Hành động</th>
          </tr>
        </thead>
        <tbody>
          {products.map((product) => (
            <tr key={product.id}>
              <td>{product.title}</td>
              <td>${product.price}</td>
              <td>{product.stock}</td>
              <td>
                <button
                  onClick={() => handleAddToCart(product.id)}
                  disabled={product.stock <= 0}
                >
                  Thêm vào giỏ hàng
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <div>trung-kieen©2025</div>
    </div>

  );
}

export default App;
