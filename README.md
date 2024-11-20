## Sommer

The `Sommer` class is a utility for building JSON strings from Java objects using a builder pattern. Below is a step-by-step guide on how to use it:

---

### **1. Overview**

The `Sommer` class provides a convenient way to:
- Convert a list of Java objects into JSON strings.
- Support both compact and pretty-printed JSON formats.
- Encapsulate JSON data in a `Sommer` object for further use.

---

### **2. Example Usage**

Here is a complete example of how to use the `Sommer` class:

#### **Import Required Dependencies**
Ensure you have Jackson in your project dependencies. Add the following Maven dependency if needed:

```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.15.0</version>
</dependency>
```

#### **Step-by-Step Example**

```java
import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            // Step 1: Create a list of objects to be converted to JSON
            List<Object> sampleData = Arrays.asList(
                "John Doe",
                42,
                true,
                new String[]{"Java", "Spring"}
            );

            // Step 2: Use the Sommer.JSONBuilder to build a Sommer instance
            Sommer sommer = new Sommer.JSONBuilder()
                .addData(sampleData)        // Add data to the builder
                .parseToJSON()              // Convert data to JSON string
                .build();                   // Build the Sommer instance

            // Step 3: Access the JSON string from the Sommer instance
            System.out.println("Compact JSON:");
            System.out.println(sommer.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

### **3. Class Details**

#### **`Sommer` Class**
- **Purpose**: Represents an encapsulated JSON object created through the builder.
- **Methods**:
  - `String getData()`: Retrieves the JSON string.
  - `void setData(String data)`: Allows manual modification of the JSON string.

#### **`JSONBuilder` Class**
- **Purpose**: A nested static builder class for constructing `Sommer` objects.
- **Key Methods**:
  - `JSONBuilder addData(List<Object> data)`: Adds data to be converted into JSON format.
  - `JSONBuilder parseToJSON()`: Converts the added data into a JSON string (both compact and pretty-printed versions are supported).
  - `Sommer build()`: Constructs and returns a `Sommer` instance.

---

### **4. Output Example**

Using the sample data from the example:

**Pretty-Printed JSON:**
```json
[
  "John Doe",
  42,
  true,
  [
    "Java",
    "Spring"
  ]
]
```

---

### **5. Error Handling**
- If JSON parsing fails (e.g., due to invalid input data), a `JsonProcessingException` will be thrown. Ensure you handle this exception appropriately.

---

### **6. Future Enhancements**
You can extend this class to:
- Support additional data types.
- Write JSON output to a file or stream.
- Add validations for input data.

---

With the `Sommer` class, you can quickly convert Java objects into well-formatted JSON strings for use in APIs, logs, or file outputs.
