package pt.iade.games.gamedevedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.games.gamedevedex.models.Project
import pt.iade.games.gamedevedex.models.Student
import pt.iade.games.gamedevedex.ui.components.ProjectCard
import pt.iade.games.gamedevedex.ui.theme.GamedevedexTheme
import java.net.URI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GamedevedexTheme {
                MainView()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Gamedevedex")
                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            ProjectCard(
                modifier = Modifier.padding(vertical = 20.dp),
                project = ProjectExample()
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MainViewPreview() {
    GamedevedexTheme {
        MainView()
    }
}

fun ProjectExample(): Project {
    return Project(
        title = "Among Us",
        votes = 2,
        description = "Super sus.",
        id = 404,
        semester = 1,
        assets = listOf(
            URI.create("https://cdn.mobygames.com/screenshots/12341377-among-us-windows-calling-an-emergency-meeting.png"),
            URI.create("https://lutris.net/media/games/screenshots/ss_649e19ff657fa518d4c2b45bed7ffdc4264a4b3a.jpg")
        ),
        groupMembers = listOf(
            Student(
                id = 123,
                name = "João Pedro",
                biography = "Love playing Valorant. Currently thinking of switching courses.",
                mood = "Lucky",
                avatar = URI.create("https://media.gettyimages.com/photos/cristiano-ronaldo-of-portugal-poses-during-the-official-fifa-world-picture-id450555852?k=6&m=450555852&s=612x612&w=0&h=aUh0DVio_ubpFtCVvMv3WLR1MVPQji1sN5PDNKvHCT4=")
            )
        )
    )
}
