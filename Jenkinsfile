pipeline {
    agent any
    environment {
        SEMGREP_APP_TOKEN = credentials('SEMGREP_APP_TOKEN') // Variable de entorno para Semgrep
    }
    stages {
        stage('Semgrep-Scan') {
            steps {
                bat '''
                docker pull returntocorp/semgrep ^
                && docker run ^
                -e SEMGREP_APP_TOKEN=%SEMGREP_APP_TOKEN% ^
                -v "%cd%:%cd%" ^
                --workdir "%cd%" ^
                returntocorp/semgrep semgrep ci
                '''
            }
        }
    }
}
