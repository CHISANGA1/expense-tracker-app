import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val description: String,
    val amount: Double,
    val timestamp: String
)