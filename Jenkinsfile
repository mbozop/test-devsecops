pipeline {
    agent any
    environment {
        // The following variable is required for a Semgrep Cloud Platform-connected scan:
        SEMGREP_APP_TOKEN = credentials('283a50b4104bc49932da73d79350b9d744d667a427ff662f36806a19d03b9b9b')
    }
    stages {
        stage('Semgrep-Scan') {
            steps {
                sh '''
                docker pull returntocorp/semgrep &&
                docker run \
                -e SEMGREP_APP_TOKEN=$SEMGREP_APP_TOKEN \
                -v "$(pwd):$(pwd)" --workdir $(pwd) \
                returntocorp/semgrep semgrep ci
                '''
            }
        }
    }
}
