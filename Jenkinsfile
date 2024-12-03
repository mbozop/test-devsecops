pipeline {
    agent any
    environment {
        SEMGREP_APP_TOKEN = credentials('SEMGREP_APP_TOKEN')
    }
    stages {
        stage('Semgrep-Scan') {
            steps {
                bat '''
                docker pull returntocorp/semgrep ^
                && docker run ^
                -e SEMGREP_APP_TOKEN=%SEMGREP_APP_TOKEN% ^
                -v "%cd%:/workspace" ^
                --workdir /workspace ^
                returntocorp/semgrep semgrep ci
                '''
            }
        }
        stage('Nuclei-Scan') {
            steps {
                bat '''
                docker pull projectdiscovery/nuclei ^
                && docker run ^
                -v "%cd%:/workspace" ^
                --workdir /workspace ^
                projectdiscovery/nuclei -update-templates ^
                && docker run ^
                -v "%cd%:/workspace" ^
                --workdir /workspace ^
                projectdiscovery/nuclei ^
                -t /root/nuclei-templates ^
                -headless -code -dast -file -esc ^
                -v
                '''
            }
        }
    }
}
