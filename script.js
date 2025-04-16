document.addEventListener('DOMContentLoaded', function() {
    // DOM Elements
    const tipoEntrenamiento = document.getElementById('tipoEntrenamiento');
    const roundsNumber = document.getElementById('roundsNumber');
    const workTime = document.getElementById('workTime');
    const restTime = document.getElementById('restTime');
    const warningTime = document.getElementById('warningTime');
    const gymName = document.getElementById('gymName');
    const startBtn = document.getElementById('startBtn');
    const pauseBtn = document.getElementById('pauseBtn');
    const resetBtn = document.getElementById('resetBtn');
    const settingsBtn = document.getElementById('settingsBtn');
    const roundsBtn = document.getElementById('roundsBtn');
    const currentTimeElement = document.getElementById('currentTime');
    const timerDisplayElement = document.getElementById('timerDisplay');
    const settingsPanel = document.getElementById('settingsPanel');
    const saveSettingsBtn = document.getElementById('saveSettingsBtn');
    const closeSettingsBtn = document.getElementById('closeSettingsBtn');
    const bottomLogo = document.getElementById('bottomLogo');
    
    // Timer variables
    let timer;
    let timerRunning = false;
    let currentRound = 0;
    let totalRounds = 0;
    let timeRemaining = 0;
    let totalSeconds = 0;
    let isWorkPeriod = true;
    let startTime;
    let pausedTime = 0;
    
    // Audio elements
    const startSound = new Audio('https://assets.mixkit.co/sfx/preview/mixkit-start-match-countdown-1954.mp3');
    const endSound = new Audio('https://assets.mixkit.co/sfx/preview/mixkit-boxing-bell-hits-2831.mp3');
    const warningSound = new Audio('https://assets.mixkit.co/sfx/preview/mixkit-short-warning-alarm-buzzer-991.mp3');
    
    // Update current time
    function updateCurrentTime() {
        const now = new Date();
        const hours = now.getHours().toString().padStart(2, '0');
        const minutes = now.getMinutes().toString().padStart(2, '0');
        const seconds = now.getSeconds().toString().padStart(2, '0');
        currentTimeElement.textContent = `${hours}:${minutes}:${seconds}`;
    }
    
    // Format time as HH:MM:SS
    function formatTimeHHMMSS(totalSeconds) {
        const hours = Math.floor(totalSeconds / 3600);
        const minutes = Math.floor((totalSeconds % 3600) / 60);
        const seconds = totalSeconds % 60;
        return `${hours.toString().padStart(2, '0')}:${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, '0')}`;
    }
    
    // Update the timer display
    function updateTimerDisplay() {
        timerDisplayElement.textContent = formatTimeHHMMSS(timeRemaining);
    }
    
    // Convert minutes to seconds
    function minutesToSeconds(minutes) {
        return Math.round(minutes * 60);
    }
    
    // Update gym name and rounds display
    function updateDisplayInfo() {
        const gymNameValue = gymName.value || 'JIU-JITSU';
        document.querySelector('.gym-discipline').textContent = gymNameValue;
        
        const rounds = parseInt(roundsNumber.value);
        const workMinutes = parseFloat(workTime.value);
        
        roundsBtn.querySelector('.rounds-text').textContent = `${rounds}×${workMinutes}`;
        totalRounds = rounds;
    }
    
    // Calculate total time
    function calculateTotalTime() {
        const rounds = parseInt(roundsNumber.value);
        const workSecs = minutesToSeconds(parseFloat(workTime.value));
        const restSecs = minutesToSeconds(parseFloat(restTime.value));
        
        // Total time in seconds (work + rest) * rounds - last rest period
        totalSeconds = (workSecs + restSecs) * rounds - restSecs;
        
        // Update UI
        updateDisplayInfo();
    }
    
    // Timer tick
    function timerTick() {
        if (timeRemaining <= 0) {
            // Play sound
            endSound.play();
            
            if (isWorkPeriod) {
                // Work period ended, start rest period
                if (currentRound < totalRounds) {
                    isWorkPeriod = false;
                    timeRemaining = minutesToSeconds(parseFloat(restTime.value));
                } else {
                    // Workout completed
                    clearInterval(timer);
                    timerRunning = false;
                    startBtn.disabled = false;
                    pauseBtn.disabled = true;
                    return;
                }
            } else {
                // Rest period ended, start work period
                currentRound++;
                isWorkPeriod = true;
                timeRemaining = minutesToSeconds(parseFloat(workTime.value));
            }
        }
        
        // Check for warning time
        if (timeRemaining === parseInt(warningTime.value) && warningTime.value > 0) {
            warningSound.play();
        }
        
        updateTimerDisplay();
        timeRemaining--;
    }
    
    // Preset configurations
    function setPresetConfig() {
        const selectedValue = tipoEntrenamiento.value;
        
        switch(selectedValue) {
            case 'jiujitsu':
                roundsNumber.value = 5;
                workTime.value = 5; // 5 minutes
                restTime.value = 1; // 1 minute
                break;
            case 'mma':
                roundsNumber.value = 3;
                workTime.value = 5; // 5 minutes
                restTime.value = 1; // 1 minute
                break;
            case 'boxeo':
                roundsNumber.value = 12;
                workTime.value = 3; // 3 minutes
                restTime.value = 1; // 1 minute
                break;
            case 'muaythai':
                roundsNumber.value = 5;
                workTime.value = 3; // 3 minutes
                restTime.value = 2; // 2 minutes
                break;
            // For 'personalizado', keep the current values
        }
        
        calculateTotalTime();
    }
    
    // Start timer
    function startTimer() {
        if (timerRunning) return;
        
        if (pausedTime === 0) {
            // New session
            currentRound = 1;
            isWorkPeriod = true;
            timeRemaining = minutesToSeconds(parseFloat(workTime.value));
            startSound.play();
        }
        
        startTime = Date.now() - pausedTime;
        pausedTime = 0;
        
        timer = setInterval(timerTick, 1000);
        timerRunning = true;
        
        startBtn.disabled = true;
        pauseBtn.disabled = false;
    }
    
    // Pause timer
    function pauseTimer() {
        if (!timerRunning) return;
        
        clearInterval(timer);
        timerRunning = false;
        pausedTime = Date.now() - startTime;
        
        startBtn.disabled = false;
        pauseBtn.disabled = true;
    }
    
    // Reset timer
    function resetTimer() {
        clearInterval(timer);
        timerRunning = false;
        pausedTime = 0;
        
        currentRound = 0;
        timeRemaining = 0;
        timerDisplayElement.textContent = '00:00:00';
        
        startBtn.disabled = false;
        pauseBtn.disabled = true;
    }
    
    // Toggle settings panel
    function toggleSettings() {
        settingsPanel.style.display = settingsPanel.style.display === 'flex' ? 'none' : 'flex';
    }
    
    // Save settings
    function saveSettings() {
        calculateTotalTime();
        toggleSettings();
    }
    
    // Event listeners
    tipoEntrenamiento.addEventListener('change', setPresetConfig);
    
    startBtn.addEventListener('click', startTimer);
    pauseBtn.addEventListener('click', pauseTimer);
    resetBtn.addEventListener('click', resetTimer);
    
    settingsBtn.addEventListener('click', toggleSettings);
    saveSettingsBtn.addEventListener('click', saveSettings);
    closeSettingsBtn.addEventListener('click', toggleSettings);
    
    // Initialize
    setInterval(updateCurrentTime, 1000);
    updateCurrentTime();
    setPresetConfig();
    resetTimer();
}); 