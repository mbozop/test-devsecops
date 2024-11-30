pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/mbozop/test-devsecops.git',
                    credentialsId: 'general-id'
            }
        }

        stage('Run Semgrep') {
            steps {
                echo 'Running Semgrep...'
                bat '''
                pip install semgrep
                semgrep --config=auto --json --output semgrep-report.json || exit 0
                '''
            }
        }

        stage('Publish Reports') {
            steps {
                echo 'Publishing Semgrep report...'
                archiveArtifacts artifacts: 'semgrep-report.json', allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution complete.'
        }
    }
}
