## `Sommer` (WIP)

`Sommer` provides a convenient utility for building JSON strings from Java objects. The package ships with Jackson as a transitive dependency, so you don’t need to explicitly include it in your project.

---

### **1. Overview**

`Sommer` package allows you to:
- Convert Java objects into JSON strings.
- Use either compact or pretty-printed JSON formats.

---

### **2. Adding the Dependency**

To use `Sommer` in your project, add the following dependency to your **Maven** `pom.xml`:

```xml
<dependency>
    <groupId>com.yourorg.sommer</groupId>
    <artifactId>sommer</artifactId>
    <version>1.0.0</version>
</dependency>
```

If you are using **Gradle**, add this to your `build.gradle`:

```gradle
implementation 'com.yourorg.sommer:sommer:1.0.0'
```

> **Note**: The Jackson library is included as a transitive dependency, so no additional configuration is needed for JSON processing.
---

### **3. Example Usage**

Here is an example demonstrating how to use the `Sommer` package:

#### **Step-by-Step Example**

```java
import com.yourorg.sommer.Sommer;

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
            System.out.println("Pretty-Printed JSON:");
            System.out.println(sommer.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---
<!--
### **4. Class Details**

#### **`Sommer` Class**
- **Purpose**: Encapsulates the JSON string generated from input data.
- **Methods**:
  - `String getData()`: Retrieves the JSON string.
  - `void setData(String data)`: Allows manual modification of the JSON string.

#### **`JSONBuilder` Class**
- **Purpose**: A static nested builder class for constructing `Sommer` objects.
- **Key Methods**:
  - `JSONBuilder addData(List<Object> data)`: Adds data to be converted to JSON.
  - `JSONBuilder parseToJSON()`: Converts the added data into a JSON string.
  - `Sommer build()`: Constructs and returns a `Sommer` instance.
-->
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
- If the data cannot be converted to JSON (e.g., invalid input), the method `parseToJSON` will throw a `JsonProcessingException`. Ensure you handle this exception.

---

### **6. Future Enhancements**
This package can be extended to:
- Write JSON output directly to files or streams.
- Support additional data formats like XML or YAML.
- Add validation logic for input data.

---

The `Sommer` package simplifies JSON serialization while providing flexibility through the builder pattern. Get started with clean, pretty-printed JSON output in just a few lines of code!
